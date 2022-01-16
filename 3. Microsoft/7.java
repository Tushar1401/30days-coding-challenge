// Ques - Unit Area of largest region of 1's 

int count = 0;
    public int findMaxArea(int[][] grid)
    {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    count = 0;
                    helper(grid,i,j,vis);
                    result = Math.max(result,count);
                }
            }
        }
        return result;
    }
    
    public void helper(int[][] grid, int i, int j, boolean[][] vis){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j] == true){
            return;
        }
        
        vis[i][j] = true;
        if(grid[i][j] == 1) count++;
        helper(grid, i - 1, j, vis);
        helper(grid, i + 1, j, vis);
        helper(grid, i, j - 1, vis);
        helper(grid, i, j + 1, vis);
        helper(grid, i - 1, j - 1, vis);
        helper(grid, i + 1, j + 1, vis);
        helper(grid, i - 1, j + 1, vis);
        helper(grid, i + 1, j - 1, vis);
    }