// Ques - Power Of Numbers 

    int mod = 1000000007;   
    long power(int N,int R)
    {
        return helper(N,R) % mod;
    }
    
    long helper(int N, int R){
        if(R == 0)
            return 1;
            
        long result = power(N,R/2);
        result = (result*result) % mod;
        
        if(R%2 == 0)
            return result;
        else
            return result*N;
    }