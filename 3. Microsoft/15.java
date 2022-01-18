// Ques - .Find the order of characters in the alien language.

public String findOrder(String [] dict, int N, int K)
    {
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>(); 
        
        for(String word : dict){
            for(char ch : word.toCharArray()){
                indegree.put(ch,0);
            }
        }
        
        for(int i=0;i<dict.length - 1;i++){
            String curr = dict[i];
            String next = dict[i + 1];
            boolean flag = false;
            
            int len = Math.min(curr.length(),next.length());
            for(int j=0;j<len;j++){
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                
                if(ch1 != ch2){
                    
                    HashSet<Character> set = new HashSet<>();
                    if(graph.containsKey(ch1)){ 
                        set = graph.get(ch1); 
                        if(set.contains(ch2) == false){
                            set.add(ch2);
                            indegree.put(ch2,indegree.get(ch2) + 1);
                            graph.put(ch1,set); 
                        }
                    }else{
                        set.add(ch2);
                        indegree.put(ch2,indegree.get(ch2) + 1);
                        graph.put(ch1,set); 
                    }
                    
                    flag = true;
                    break; 
                }
            }
            
            if(flag == false){
                if(curr.length() > next.length()){ 
                    return "";
                }
            }
        }
        
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        
        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                queue.addLast(ch);
            }
        }
        
        int count = 0;
        
        while(queue.size() > 0){
            char rem = queue.removeFirst();
            ans.append(rem);
            count++; 
            
            if(graph.containsKey(rem)){
                HashSet<Character> nbrs = graph.get(rem);
                
                for(char nbr : nbrs){
                    indegree.put(nbr,indegree.get(nbr) - 1);
                    if(indegree.get(nbr) == 0){
                        queue.addLast(nbr); 
                    }
                }
            }
               
        }
        
        if(count == indegree.size()){ 
            return ans.toString();
        }else{
            return "";
        }
    }