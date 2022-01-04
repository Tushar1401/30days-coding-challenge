// Ques - Minimum size subarray sum

public int minSubArrayLen(int target, int[] nums) {
    int sum = 0;
    int s = 0;
    int e = 0;
    int min = Integer.MAX_VALUE;
    while(e < nums.length){
        sum += nums[e];
        while(s <= e && sum >= target){
            if(sum >= target){
                min = Math.min(min,e - s + 1);
            }
            sum -= nums[s];
            s++;
        }
        e++;
    }
    return min == Integer.MAX_VALUE ? 0 : min;
}