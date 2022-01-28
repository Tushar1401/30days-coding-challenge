// Ques - Stone Game

class Solution {
    public boolean stoneGame(int[] arr) {
        int n = arr.length;
		int[][] dp = new int[n][n];
		
		for(int g=0;g<n;g++){
		    for(int i=0,j=g;j<n;i++,j++){
		        if(g == 0){
		            dp[i][j] = arr[i];
		        }else if(g == 1){
		            dp[i][j] = Math.max(arr[i],arr[j]);
		        }else{
		            int v1 = arr[i] + Math.min(dp[i + 2][j],dp[i + 1][j - 1]);
		            int v2 = arr[j] + Math.min(dp[i + 1][j - 1],dp[i][j - 2]);
		            dp[i][j] = Math.max(v1,v2);
		        }
		    }
		}
		
		return dp[0][n - 1] > 0;
    }
}