// Ques - Stickler Thief (Similar to Alibaba and Thiefes Question) 

public int FindMaxSum(int arr[], int n)
    {
        int inc = arr[0];
        int exc = 0;
        
        for(int i=1;i<n;i++){
            int new_inc = exc + arr[i];
            int new_exc = Math.max(inc,exc);
            
            inc = new_inc;
            exc = new_exc;
        }
        
        return Math.max(inc,exc);
    }