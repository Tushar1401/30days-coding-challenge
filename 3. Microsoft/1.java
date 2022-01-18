// Ques - Divide an array into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference

public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int val : arr) sum += val;
	    
	    boolean[][] dp = new boolean[n + 1][sum + 1];
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=sum;j++){
	            if(i == 0 && j == 0) dp[i][j] = true;
	            else if(i == 0) dp[i][j] = false;
	            else if(j == 0) dp[i][j] = true;
	            else if(arr[i - 1] <= j){
	                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
	            }else{
	                dp[i][j] = dp[i - 1][j];
	            }
	        }
	    }
	    
	    int diff = Integer.MAX_VALUE;
	    for(int i=0;i<=sum/2;i++){
	        if(dp[n][i] == true){
	            diff = Math.min(diff,sum - 2*i);
	        }
	    }
	    
	    return diff;
	} 