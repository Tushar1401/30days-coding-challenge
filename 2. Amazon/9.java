// Ques - Which among them forms a perfect Sudoku Pattern ?

static int isValid(int mat[][]){
        
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(mat[i][j] != 0 && check(mat,i,j,mat[i][j]) == false){
                return 0;
            }
        }
    }
    
    return 1;
}

static boolean check(int[][] board, int i, int j, int val){
  
  
    for(int c = 0;c<board.length;c++){
        if(board[i][c] == val && c != j){
            return false;
        }
    }
  
    for(int r = 0;r<board.length;r++){
        if(board[r][j] == val && r != i){
            return false;
        }
    }
  
    int ni = i/3 * 3;
    int nj = j/3 * 3;
  
    for(int r=0;r<3;r++){
        for(int c=0;c<3;c++){
            if(board[ni + r][nj + c] == val && ni + r != i && nj + c != j){
                return false;
            }
        }
    }
    return true;
}