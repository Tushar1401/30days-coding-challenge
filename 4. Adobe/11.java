// Ques - String Amendment

public String amendSentence(String s){
        
    StringBuilder str = new StringBuilder();
    StringBuilder res = new StringBuilder();
    for(char ch : s.toCharArray()){
        if(ch >= 'A' && ch <= 'Z'){
            if(str.length() != 0){
                res.append(str + " ");
                str.setLength(0);
            }
        }
        str.append(ch);
    }
    
    res.append(str);
    return res.toString().toLowerCase();
}