// Ques - Koko Eating Bananas

public int minEatingSpeed(int[] piles, int h) {
    int max = 0;
    for(int val : piles){
        max = Math.max(max,val);
    }
    
    if(h == piles.length) return max;
    
    int low = 0;
    int high = max;
    
    int ans = 0;
    
    while(low <= high){
        int mid = low + (high - low)/2; // to avoid overflow
        if(isPossible(piles,mid,h)){
            ans = mid;
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
    
    return ans;
}

public boolean isPossible(int[] arr, int mid, int h){
    int count = 0;
    for(int val : arr){
        count += (int)Math.ceil(val*1.0/mid);
    }
    return count <= h;
}