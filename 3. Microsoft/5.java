// Ques - Stock span problem

public static int[] calculateSpan(int arr[], int n)
    {
       int[] ans = new int[arr.length];
       ans[0] = 1;
       Stack<Integer> st = new Stack<>();
       st.push(0);
   
       for(int i=1;i<arr.length;i++){
           while(st.size() != 0 && arr[i] >= arr[st.peek()]){
               st.pop();
           }
       
           if(st.size() == 0){
               ans[i] = i + 1;
           }else{
               ans[i] = i - st.peek();
           }
           st.push(i);
       }
   
       return ans;
    }