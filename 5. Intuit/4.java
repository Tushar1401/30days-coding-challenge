// Ques - Largest Number in k swaps

public static void swap(char[] str, int i, int j){
    char ch = str[i];
    str[i] = str[j];
    str[j] = ch;
}

static String max;
public static void helper(char[] str, int k){
    if(max.compareTo(String.valueOf(str)) < 0){
        max = String.valueOf(str);
    }
    
    if(k == 0) return;
    
    for(int i=0;i<str.length - 1;i++){
        for(int j=i + 1;j<str.length;j++){
            if(str[j] > str[i]){
                swap(str,i,j);
                helper(str,k - 1);
                swap(str,i,j);
            }
        }
    }
}

public static String findMaximumNum(String str, int k){
    max = str;
    helper(str.toCharArray(),k);
    return max;
}