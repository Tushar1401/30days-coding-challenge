// Ques - Capacity To Ship Packages Within D Days

public int shipWithinDays(int[] weights, int days) {
    int max = 0;
    int sum = 0;
    for(int val : weights){
        max = Math.max(max,val);
        sum += val;
    }

    if(weights.length == days){
        return max;
    }
    
    int ans = Integer.MAX_VALUE;
    int low = max;
    int high = sum;
    
    while(low <= high){
        int mid = low + (high - low)/2;
        
        if(isPossible(weights,days,mid)){
            ans = mid;
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
    
    return ans;
}

public boolean isPossible(int[] arr, int days, int target){
    int count = 1;
    int sum = 0;
    for(int val : arr){
        sum += val;
        if(sum > target){
            sum = val;
            count++;
        }
    }
    return count <= days;
}