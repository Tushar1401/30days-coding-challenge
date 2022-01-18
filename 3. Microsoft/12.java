// Ques - Find all the unique quadruple from the given array that sums up to the given number.

public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if(arr == null || arr.length == 0){
        return res;
    }
    int n = arr.length;
    Arrays.sort(arr);
    
    for(int i=0;i<n;i++){
        for(int j=i + 1;j<n;j++){
            int target = k - arr[i] - arr[j];
            int front = j + 1;
            int back = n - 1;
            
            while(front < back){
                int twoSum = arr[front] + arr[back];
                
                if(twoSum < target) front++;
                else if(twoSum > target) back--;
                else{
                    ArrayList<Integer> quad = new ArrayList<>();
                    quad.add(arr[i]);
                    quad.add(arr[j]);
                    quad.add(arr[front]);
                    quad.add(arr[back]);
                    res.add(quad);
                    
                    while(front < back && arr[front] == quad.get(2)) front++;
                    
                    while(front < back && arr[back] == quad.get(3)) back--;
                }
            }
            
            while(j + 1 < n && arr[j + 1] == arr[j]) j++;
        }
        
        while(i + 1 < n && arr[i + 1] == arr[i]) i++;
    }
    
    return res;
}