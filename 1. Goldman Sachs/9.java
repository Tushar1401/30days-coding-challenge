// Ques - Number following pattern

static String printMinNumberForPattern(String str){
    Stack<Integer> st = new Stack<>();
    int n = 1;
    for(char ch : str.toCharArray()){
        if(ch == 'D'){
            st.push(n);
        }else{
            st.push(n);
            while(st.size() != 0){
                System.out.print(st.pop());
            }
        }
        n++;
    }
    st.push(n);
    StringBuilder sb = new StringBuilder();
    while(st.size() != 0){
        sb.append(st.pop());
    }
    return sb.toString();
}