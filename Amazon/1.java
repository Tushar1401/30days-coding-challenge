// Ques - Calculating Maximum profit

static int maxProfit(int k, int n, int arr[]) {
    int[][] dp = new int[k + 1][n];
    
    for(int trans=1;trans<=k;trans++){
        int max = Integer.MIN_VALUE;
        for(int day=1;day<n;day++){
            max = Math.max(max,dp[trans - 1][day - 1] - arr[day - 1]);
            dp[trans][day] = Math.max(dp[trans][day - 1],max + arr[day]);
        }
    }
    
    return dp[k][n - 1];
}