// Ques - Column name from a given column number 

String colName (long n)
    {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            char ch = (char)('A' + (n - 1)%26);
            n = (n - 1)/26;
            sb.append(ch);
        }
        sb = sb.reverse();
        return sb.toString();
    }