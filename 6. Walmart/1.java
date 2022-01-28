// Ques - Path with Maximum Probability

class Solution {
    public class Edge{
        int vtx;
        int nbr;
        double wt;

        Edge(int vtx, int nbr, double wt) {
           this.vtx = vtx;
           this.nbr = nbr;
           this.wt = wt;
        } 
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int vtces = n;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int i = 0;
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            double wt = succProb[i++];
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        
        boolean[] vis = new boolean[vtces];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.add(new double[]{start, 1});
        
        while(pq.size() != 0){
            double[] rem = pq.remove();
            int node = (int)rem[0];
            double prob = rem[1];
            
            if(node == end) return prob;
            if(vis[node]) continue;
            
            vis[node] = true;
            
            for(Edge e : graph[node]){
                if(vis[e.nbr] == false){
                    pq.add(new double[]{e.nbr,prob * e.wt});   
                }
            }
        }
        return 0;
    }
}