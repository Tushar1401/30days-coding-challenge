// Ques - Sorted Subsequence of size 3

ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
    if(arr.size() < 3){
        return new ArrayList<Integer>();
    }
    
    int[] rge = new int[n];
    int[] lse = new int[n];
    rge[n - 1] = -1;
    lse[0] = -1;
    
    Stack<Integer> st = new Stack<>();
    st.push(n - 1);
    
    for(int i=n - 2;i>=0;i--){
        while(st.size() != 0 && arr.get(i) >= arr.get(st.peek())){
            st.pop();
        }
        if(st.size() == 0){
            rge[i] = -1;
        }else{
            rge[i] = arr.get(st.peek());
        }
        st.push(i);
    }
    
    st = new Stack<>();
    st.push(0);
    
    for(int i=1;i<n;i++){
        while(st.size() != 0 && arr.get(i) <= arr.get(st.peek())){
            st.pop();
        }
        if(st.size() == 0){
            lse[i] = -1;
        }else{
            lse[i] = arr.get(st.peek());
        }
        st.push(i);
    }
    
    ArrayList<Integer> res = new ArrayList<>();
    for(int i=0;i<n;i++){
        int num = arr.get(i);
        if(lse[i] != -1 && rge[i] != -1){
            res.add(lse[i]);
            res.add(num);
            res.add(rge[i]);
            return res;
        }
    }
    return res;
}