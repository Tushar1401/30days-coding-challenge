// Ques - Course Schedule - II

class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
       this.src = src;
       this.nbr = nbr;
    }
}

public int[] findOrder(int numCourses, int[][] prerequisites) {
    int vtces = numCourses;
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
       graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < prerequisites.length; i++) {
       int v1 = prerequisites[i][0];
       int v2 = prerequisites[i][1];
       graph[v1].add(new Edge(v1, v2));
    }

    Stack<Integer> st = new Stack<>();
    boolean[] vis = new boolean[vtces];
    boolean[] cycle = new boolean[vtces];

    for(int i=0;i<vtces;i++){
        boolean flag = helper(st,graph,i,cycle,vis);
        if(flag){ // cycle detected
           return new int[0];
        }
    }

    int[] res = new int[st.size()];
    int idx = res.length - 1;
    while(st.size() != 0){
        res[idx--] = st.pop();
    }

    return res;
}

public boolean helper(Stack<Integer> st, ArrayList<Edge>[] graph, int src, boolean[] cycle, boolean[] vis){
    if(vis[src] == true) return false;
    if(cycle[src] == true) return true;
  
    cycle[src] = true;
    for(Edge e : graph[src]){
        if(helper(st,graph,e.nbr,cycle,vis)) return true;
    }
    vis[src] = true;
    cycle[src] = false;
    st.push(src);
    return false;
}