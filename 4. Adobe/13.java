// Ques - Minimum operations to convert array A to B 

// ------ RECUSIVE & MEMORIZED ------

static int minInsAndDel(int[] A, int[] B, int N, int M) {
    int[][] dp = new int[N + 1][M + 1];
    for(int[] row : dp){
        Arrays.fill(row,-1);
    }
    return helper(A,B,N,M,dp);
}

static int helper(int[] a, int[] b, int n, int m, int[][] dp){
    if(n == 0) return m;
    if(m == 0) return n;
    
    if(dp[n][m] != -1) return dp[n][m];
    
    int ans = 0;
    if(a[n - 1] == b[m - 1]) ans = helper(a,b,n - 1,m - 1,dp);
    else ans = Math.min(helper(a,b,n - 1,m,dp),helper(a,b,n,m - 1,dp)) + 1;
    
    dp[n][m] = ans;
    return ans;
}

// ------ DP ------

static int minInsAndDel(int[] A, int[] B, int N, int M) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int val : A){
        if(isPresent(B,val)){
            list.add(val);
        }
    }
    int lis = lis(list);
    return (N + M - 2*lis);
    
}

static boolean isPresent(int[] b, int tar){
    int l = 0;
    int r = b.length - 1;
    while(l <= r){
        int mid = (l + r)/2;
        if(b[mid] == tar) return true;
        else if(b[mid] < tar) l = mid + 1;
        else r = mid - 1;
    }
    return false;
}

static int lis(ArrayList<Integer> list){
    if (list.size() == 0) {
        return 0;
    }
    int[] tail = new int[list.size()];
    int len = 1;
    tail[0] = list.get(0);
       
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) > tail[len - 1]) {
            tail[len++] = list.get(i);
        } else {
            int id = Arrays.binarySearch(tail, 0, len-1, list.get(i));
            if (id < 0) {
                id = -1*id - 1;
            }
            tail[id] = list.get(i);
        }
    }
    return len;
}