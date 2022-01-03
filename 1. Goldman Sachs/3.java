// Ques - Count the subarrays having product less than k 

public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int count = 0,s = 0, e = 0;
        long p = 1;
        while(e < n){
            p *= a[e];
            while(s < e && p >= k){
                p /= a[s];
                s++;
            }
            if(p < k){
                int len = e - s + 1;
                count += len;
            }
            e++;
        }
    	return count;
    }