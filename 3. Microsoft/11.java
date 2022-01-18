// Ques - Generate and print all binary numbers with decimal values from 1 to N.  

static ArrayList<String> generate(int N)
    {
        ArrayList<String> res = new ArrayList<>();
        
        for(int i=1;i<=N;i++){
            res.add(helper(i));
        }
        
        return res;
    }
    
    static String helper(int n){
        int res = 0, p = 1;
        while(n != 0){
            int rem = n%2;
            n /= 2;
            res += rem*p; 
            p *= 10;
        }
        return res + "";
    }
