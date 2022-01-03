// Ques - Total Decoding Ways

public int CountWays(String str)
    {
        // code here
        if(str.charAt(0) == '0') return 0;
        long[] dp = new long[str.length()];
        dp[0] = 1;
        int mod = 1000000007;
        for(int i=1;i<dp.length;i++){
            if(str.charAt(i - 1) == '0'){
                if(str.charAt(i) != '0'){
                    dp[i] = dp[i - 1];
                }
            }else{
                if(str.charAt(i) != '0'){
                    dp[i] = dp[i - 1];
                }
                
                if(Integer.parseInt(str.substring(i - 1,i + 1)) <= 26){
                    dp[i] += i == 1 ? 1 : dp[i - 2];
                }
            }
            dp[i] = dp[i] % mod;
        }
        return (int) (dp[dp.length - 1] % mod);
    }