// Ques - Run length encoding

String encode(String str)
	{        
        String res = "";
        int count = 1;
        for(int i=1;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == str.charAt(i - 1)) count++;
            else{
                res = res + str.charAt(i - 1) + count;
                count = 1;
            }
        }
        res = res + str.charAt(str.length() - 1) + count;
        return res;
	}