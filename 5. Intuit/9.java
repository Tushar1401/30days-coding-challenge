// Ques - Pacific Atlantic Water Flow

int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return res;
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int j=0;j<n;j++){
            dfs(heights,0,j,Integer.MIN_VALUE,pacific);
            dfs(heights,m - 1,j,Integer.MIN_VALUE,atlantic);
        }
        
        for(int i=0;i<m;i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,n - 1,Integer.MIN_VALUE,atlantic);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] arr, int i, int j, int prev, boolean[][] ocean){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;
        
        if(arr[i][j] < prev || ocean[i][j]) return;
        
        ocean[i][j] = true;
        for(int[] dir : dirs){
            dfs(arr,i + dir[0],j + dir[1],arr[i][j],ocean);
        }
    }