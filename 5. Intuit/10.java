// Ques - Number of Provinces

public class Edge{
    int src;
    int nbr;
    public Edge(int src, int nbr){
        this.src = src;
        this.nbr = nbr;
    }
}
public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    ArrayList<Edge>[] graph = new ArrayList[n];
    boolean[] vis = new boolean[n];
    
    for(int i=0;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(isConnected[i][j] == 1 && i != j){
                graph[i].add(new Edge(i,j));
                // graph[j].add(new Edge(j,i));
            }
        }
    }
    
    int count = 0;
    for(int i=0;i<n;i++){
        if(vis[i] == false){
            gcc(graph,i,vis);
            count++;
        }
    }
    return count;
}

public void gcc(ArrayList<Edge>[] graph, int src, boolean[] vis){
   vis[src] = true;
   for(Edge e : graph[src]){
       if(vis[e.nbr] == false){
           gcc(graph,e.nbr,vis);
       }
   }
}