// Ques - Guess Number Higher or Lower II

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 1];
        
        for(int len = 2;len<=n;len++){
            for(int start = 1;start<=n - len + 1;start++){
                int end = start + len - 1;
                
                int currMin = Integer.MAX_VALUE;
                for(int pivot=start;pivot<=end;pivot++){
                    
                    currMin = Math.min(currMin,pivot + Math.max(dp[start][pivot - 1],dp[pivot + 1][end]));
                }
                
                dp[start][end] = currMin;
            }
        }
        
        return dp[1][n];
    }
}