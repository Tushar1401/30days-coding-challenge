// Ques - Smallest range in K lists 

static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    int[] res = {-100000,100000};
        
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        for(int i=0;i<k;i++){
            int mol = arr[i][0]; // min of list ... sub lists are sorted
            
            // 0th - minimum element of the list
            // 1st - index of element from the list
            // 2nd - index of list in nums
            
            int[] tba = {mol, 0, i}; 
            
            max = Math.max(max,mol);
            pq.add(tba);
            
        }
        
        while(true){
            int[] min = pq.poll();
            if(res[1]  - res[0] > max - min[0]){
                res[0] = min[0];
                res[1] = max;
            }
            
            min[1]++;
            int[] cl = arr[min[2]]; // current list
            
            if(min[1] == cl.length){
                break;
            }else{
                min[0] = cl[min[1]];
                max = Math.max(max,cl[min[1]]);
                pq.add(min);
            }
        }
        
        return res;
	}