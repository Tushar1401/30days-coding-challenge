// Ques - Possible Words From Phone Digits

static String[] codes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static ArrayList <String> possibleWords(int a[], int N)
    {
        return helper(a,0);
    }
    
    static ArrayList<String> helper(int[] arr, int i) {
        if(i == arr.length){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = (char)(arr[i] + '0');
        
        ArrayList<String> rres = helper(arr, i + 1);
        ArrayList<String> mres = new ArrayList<>();
        String code = codes[ch - '0'];
        
        for(char chcode : code.toCharArray()){
            for(String s : rres){
                mres.add(chcode + s);
            }
        }        
        
        return mres;
    }