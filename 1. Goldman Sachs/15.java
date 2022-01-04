// Ques - Array Pair Sum Divisibility Problem

public boolean canPair(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    
    for(int val : nums){
        map.put(val%k, map.getOrDefault(val%k,0) + 1);
    }
    
    for(int rem : map.keySet()){
        if(rem == 0){
            if(map.get(rem)%2 == 1){
                return false;
            }
        }else if(2*rem == k){
            if(map.get(rem)%2 == 1){
                return false;
            }
        }else{
            if(map.get(rem) != map.get(k - rem)){
                return false;
            }
        }
    }
    return true;
}