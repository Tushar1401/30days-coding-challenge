// Ques - As Far from Land as Possible

public class Pair{
    int i;
    int j;
    
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public int maxDistance(int[][] grid) {
    Queue<Pair> q = new ArrayDeque<>();
    
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j] == 1){
                q.add(new Pair(i,j));
            }
        }
    }
    
    if(q.size() == 0 || q.size() == grid.length*grid[0].length) return -1;
    
    int ans = -1;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    
    while(q.size() != 0){
        int size = q.size();
        ans++;
        
        while(size-- > 0){
            Pair rem = q.remove();
            
            for(int[] dir : dirs){
                int row = rem.i + dir[0];
                int col = rem.j + dir[1];
                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0){
                    q.add(new Pair(row,col));
                    grid[row][col] = 1;
                }
            }
        }
    }
    return ans;
}