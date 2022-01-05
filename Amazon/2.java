// Ques - Longest Mountain

public int longestMountain(int[] arr) {
    int n = arr.length;
    int[] lis = new int[n];
    
    for(int i=0;i<n;i++){
        if(i != 0 && arr[i] > arr[i - 1]){
            lis[i] = lis[i - 1] + 1;
        }
    }
    int[] lds = new int[n];
    
    for(int i=n - 1;i>=0;i--){
        if(i != n - 1 && arr[i] > arr[i + 1]){
            lds[i] = lds[i + 1] + 1;
        }
    }
    
    int ans = 0;
    
    for(int i=0;i<n;i++){
        if (lis[i] != 0 && lds[i] != 0) {
            ans = Math.max(lis[i] + lds[i] + 1, ans);
        }
    }
    
    return ans;
}