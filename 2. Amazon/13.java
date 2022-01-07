// Ques - Rotten Oranges

class Pair{
    int i;
    int j;
    
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Queue<Pair> q = new ArrayDeque<>();
    
    int count = 0;
    int check = 0;
    
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j] == 2){
                q.add(new Pair(i,j));
            }
            if(grid[i][j] != 0){
                count++;
            }
        }
    }
    
    if(count == 0) return count;
    
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    
    int days = 0;
    while(q.size() != 0){
        int size = q.size();
        check += size;

        for(int i=0;i<size;i++){
            Pair rem = q.remove();
            
            for(int d=0;d<4;d++){
                int r = rem.i + dr[d];
                int c = rem.j + dc[d];
                
                if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0 || grid[r][c] == 2) continue;
                
                grid[r][c] = 2;
                q.add(new Pair(r,c));
            }
        }
        
        // if(flag) days++;
        if(q.size() != 0) days++;
    }
    
    if(check != count) return -1;
    return days;
}