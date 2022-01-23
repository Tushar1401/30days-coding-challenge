// Ques - Split Array Largest Sum

public int splitArray(int[] nums, int m) {
    int max = 0, sum = 0;
    for(int val : nums){
        max = Math.max(max,val);
        sum += val;
    }
    
    if(m == nums.length){
        return max;
    }
    
    int lo = max;
    int hi = sum;
    int ans = 0;
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        
        if(isPossible(nums,mid,m) == true){
            ans = mid;
            hi = mid - 1;
        }else{
            lo = mid + 1;
        }
    }
    
    return ans;
}

public boolean isPossible(int[] arr, int mid, int m){
    int count = 1;
    int sum = 0;
    
    for(int val : arr){
        sum += val;
        
        if(sum > mid){
            count++;
            sum = val;
        }
    }
    return count <= m;
}