// Ques - Number of unique paths

static int count = 0;
    public static int NumberOfPath(int a, int b) 
    {
        boolean[][] vis = new boolean[a][b];
        int[][] dp = new int[a][b];
        
        for(int i=a - 1;i>=0;i--){
            for(int j=b - 1;j>=0;j--){
                if(i == a - 1){
                    dp[i][j] = 1;
                }else if(j == b - 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }