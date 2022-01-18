// Ques - Given a Graph of V vertices and E edges and another edge(c - d), the task is to find if the given edge is a Bridge. i.e., removing the edge disconnects the graph.

    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        int[] low = new int[V];
        int[] start = new int[V];
        int[] vis = new int[V];
        int timer = 1;
        
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(adj,c,d,i,-1,start,low,vis,timer)){
                    return 1;
                }
            }
        }
        
        return 0;
    }
    
    static boolean dfs(ArrayList<ArrayList<Integer>> graph, int c, int d, int node, int parent, int[] start, int[] low, int[] vis, int timer){
        vis[node] = 1;
        start[node] = low[node] = timer++;
        
        for(Integer nbr : graph.get(node)){
            if(nbr == parent) continue;
            
            if(vis[nbr] == 0){
                if(dfs(graph, c, d, nbr, node, start, low, vis, timer)) return true;
                low[node] = Math.min(low[node],low[nbr]);
                
                if(low[nbr] > start[node]){
                    if((node == c && nbr == d) || (node == d && nbr == c)){
                        return true;
                    }
                }
            }else{
                low[node] = Math.min(low[node],start[nbr]);
            }
        }
        
        return false;
    }