// Ques - Maximum Performance of a Team

public class Engineer implements Comparable<Engineer> {
    int speed;
    int eff;
    
    public Engineer(int speed, int eff){
        this.speed = speed;
        this.eff = eff;
    }
    
    public int compareTo(Engineer other){
        return this.speed - other.speed; 
    }
}
public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    List<Engineer> list = new ArrayList<>();
    for(int i=0;i<n;i++){
        list.add(new Engineer(speed[i],efficiency[i]));
    }
    Collections.sort(list,((a,b) -> b.eff - a.eff)); // sort in decreasing order of effciency
    
    PriorityQueue<Engineer> pq = new PriorityQueue<>();
    
    long totalSpeed = 0;
    long maxPerformance = 0;
    for(Engineer e : list){
        if(pq.size() == k){
            Engineer slowest = pq.remove();
            totalSpeed -= slowest.speed;
        }
        
        pq.add(e);
        totalSpeed += e.speed;
        long performanceWithNew = totalSpeed * (long)(e.eff);
        maxPerformance = Math.max(maxPerformance,performanceWithNew);
    }
    
    return (int)(maxPerformance % 1000000007);
}