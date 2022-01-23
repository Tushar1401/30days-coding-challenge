// Ques - Given two library versions of an executable: for example, “10.1.1.3” and “10.1.1.9” or “10” and “10.1”. Find out which one is more recent? Strings can be empty also.

public static void main(String[] args) {
    String[] arr = {"10.1.1.3", "10.1.1.9", "10", "10.1", "10.11", "", "10.1.2", "10.1.1.3.8.7"};
    String ans = "";
    long max = Long.MIN_VALUE;
    
    for(String str : arr){
        long num = convert(str);
        if(num > max){
            max = num;
            ans = str;
        }
    }
    
    System.out.println(ans);
}

public static long convert(String str){
    if(str.length() == 0) return 0;
    
    String[] parts = str.split("\\.");
    StringBuilder sb = new StringBuilder();
    
    for(String part : parts) sb.append(part);
    
    return Long.parseLong(sb.toString());
}