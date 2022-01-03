// Ques - Find max 10 numbers in a list having 10M entries.

void findLargestTenNumbers(int[] arr){
    PriorityQueue<Integer> pq = new PriorityQueue<>();

	    for(int i=0;i<arr.length;i++){
	        if(pq.size() != 10){
	            System.out.println("-> " + arr[i]);
	            pq.add(arr[i]);
	        }else{
	            if(arr[i] > pq.peek()){
	                System.out.println("-> " + arr[i]);
	                pq.remove();
	                pq.add(arr[i]);
	            }
	        }
	    }
	    
	    while(pq.size() != 0){
	        System.out.println(pq.remove());
	    }
}