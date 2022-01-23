// Ques - Find in mountain array

HashMap<Integer,Integer> map = new HashMap<>();
    MountainArray mountainArr;
    
    public int getVal(int idx){
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        map.put(idx,mountainArr.get(idx));
        return map.get(idx);
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.mountainArr = mountainArr;
        int peak = findPeak(1,mountainArr.length() - 1);
        int res = searchAsc(0,peak,target);
        if(res != -1){
            return res;
        }
        res = searchDesc(peak,mountainArr.length() - 1,target);
        return res;
    }
    
    public int findPeak(int low, int high){
        int mid = (low + high)/2;
        
        if(getVal(mid) > getVal(mid - 1) && getVal(mid) > getVal(mid + 1)){
            return mid;
        }
        
        if(getVal(mid) > getVal(mid - 1) && getVal(mid) < getVal(mid + 1)){
            return findPeak(mid + 1,high);
        }
        
        if(getVal(mid) < getVal(mid - 1) && getVal(mid) > getVal(mid + 1)){
            return findPeak(low,mid - 1);
        }
        
        return -1;
    }
    
    public int searchAsc(int low, int high, int target) {
        if(low > high) return -1;
        
        int mid = (low + high)/2;
        if(getVal(mid) == target) return mid;
        if(getVal(mid) < target) return searchAsc(mid + 1,high,target);
        if(getVal(mid) > target) return searchAsc(low,mid - 1,target);
        
        return -1;
    }
    
    public int searchDesc(int low, int high, int target) {
        if(low > high) return -1;
        
        int mid = (low + high)/2;
        if(getVal(mid) == target) return mid;
        if(getVal(mid) > target) return searchDesc(mid + 1,high,target);
        if(getVal(mid) < target) return searchDesc(low,mid - 1,target);
        
        return -1;
    }