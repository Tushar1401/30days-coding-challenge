// Ques - Leaders in Array

static ArrayList<Integer> leaders(int arr[], int n){
    ArrayList<Integer> res = new ArrayList<>();
    res.add(arr[n - 1]);
    int max = arr[n - 1];
    int i = n - 2;
    while(i != -1){
        if(arr[i] >= max) res.add(arr[i]);
        max = Math.max(max,arr[i]);
        i--;
    }
    
    Collections.reverse(res);
    return res;
}