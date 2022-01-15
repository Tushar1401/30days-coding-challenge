// Ques - Prerequisite Tasks (Similar to Question of Modern Park)


public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] vis = new boolean[N];
        
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }
        
        for(int[] pre : prerequisites){
            if(dfs(pre[0],vis,graph) == false){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> graph){
        if(vis[node] == true) return false;
        if(graph.get(node).size() == 0) return true;
        
        vis[node] = true;
        for(int nbr : graph.get(node)){
            if(!dfs(nbr,vis,graph)) return false;
            
        }
        vis[node] = false;
        graph.get(node).clear();
        
        return true;
    }