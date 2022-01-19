// Ques - Find a continuous sub-array which adds to a given number S

static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, sum = 0;
        
        while(j < n || sum >= s){
            if(sum < s){
                sum += arr[j];
                j++;
            }else if(sum > s){
                sum -= arr[i];
                i++;
            }else{
                res.add(i + 1);
                res.add(j);
                return res;
            }
        }
        
        return new ArrayList<>(Arrays.asList(-1));
    }