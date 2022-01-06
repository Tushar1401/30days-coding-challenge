// Ques - Count ways to N'th Stair(Order does not matter)

Long countWays(int m)
    {
        Long[] dp = new Long[m + 1];
        dp[0] = 1L;
        dp[1] = 1L;
        for(int i=2;i<=m;i++){
            dp[i] = dp[i - 2] + 1;
        }
        return dp[m];
    }    