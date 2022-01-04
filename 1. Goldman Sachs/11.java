// Ques - Find Missing And Repeating

int[] findTwoElement(int arr[], int n) {
    int xor = 0;
    int idx = 1;
    for(int val : arr){
        xor ^= val;
        xor ^= idx;
        idx++;
    }
    
    int rsbm = xor & (~xor + 1);
    int a = 0,b = 0;
    for(int val : arr){
        if((val & rsbm) == 0){
            a ^= val;
        }else{
            b ^= val;
        }
    }
    
    for(int i=1;i<=n;i++){
         if((rsbm & i) == 0){
             a ^= i;
         }else{
             b ^= i;
         }
    }
    
    for(int e : arr){
         if(a == e){
             return new int[]{a,b};
         }
         if(b == e){
             return new int[]{b,a};
         }
    }
    return new int[2];
  }