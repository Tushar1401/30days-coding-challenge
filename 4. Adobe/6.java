.Generate all combinations of well-formed(balanced) parentheses.

public List<String> AllParenthesis(int n) 
    {
        List<String> res = new ArrayList<>();
        helper(n,n,"",res);
        return res;
    }
    
    public void helper(int open, int close, String str, List<String> res){
        if(open == 0 && close == 0){
            res.add(str);
            return;
        }
        
        if(open != 0){
            helper(open - 1,close,str + "(",res);
        }
        
        if(close > open){
            helper(open,close - 1,str + ")",res);
        }
    }