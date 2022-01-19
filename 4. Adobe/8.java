// Ques - ATOI 

int atoi(String str) {
        
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch == '-' && i == 0) continue;
        if(!Character.isDigit(ch)) return -1;
    }
    if(str.charAt(0) == '-'){
        return 0 - Integer.parseInt(str.substring(1));
    }
    return Integer.parseInt(str);
}