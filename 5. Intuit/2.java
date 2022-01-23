// Ques - Word Search

public boolean isWordExist(char[][] board, String word)
    {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == false){
                    boolean res = helper(board,word,i,j,0,vis);
                    if(res){
                        return true;
                    } 
                }
            }
        }
        
        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int idx, boolean[][] vis)
    {
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] == true){
            return false;
        }
        
        if(board[i][j] != word.charAt(idx)){
            return false;
        }
        
        vis[i][j] = true;
        boolean f1 = helper(board,word,i + 1,j,idx + 1, vis);
        if(f1) return true;
        boolean f2 = helper(board,word,i - 1,j,idx + 1, vis);
        if(f2) return true;
        boolean f3 = helper(board,word,i,j + 1,idx + 1, vis);
        if(f3) return true;
        boolean f4 = helper(board,word,i,j - 1,idx + 1, vis);
        if(f4) return true;
        vis[i][j] = false;
        
        return false;
    }
