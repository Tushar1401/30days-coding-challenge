// Ques - Find the length of the Longest Arithmetic Progression (LLAP) in it.

int lengthOfLongestAP(int[] arr, int n) {
    if (arr.length < 3) {
        return arr.length;
    }
    
    HashMap<Integer,Integer>[] dp = new HashMap[arr.length];
    
    int ans = 1;
    for(int i=0;i<arr.length;i++){
        dp[i] = new HashMap<>();
        for(int j=0;j<i;j++){
            int diff = arr[i] - arr[j];
            HashMap<Integer,Integer> prevMap = dp[j];
            int newValue = prevMap.getOrDefault(diff,0) + 1;
            dp[i].put(diff,newValue);
            ans = Math.max(ans,newValue);
        }
        
    }
    
    return ans + 1;
}