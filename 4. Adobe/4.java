// Ques - Partition Equal Subset Sum

static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int val : arr) sum += val;
        
        if((sum & 1) != 1){
            return check(arr,sum/2);
        }else{
            return 0;
        }
    }
    
    static int check(int[] arr, int tar){
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(i == 0) dp[i][j] = false;
                else if(j == 0) dp[i][j] = true;
                else{
                    if(arr[i - 1] <= j){
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[dp.length - 1][tar] == true ? 1 : 0;
    }