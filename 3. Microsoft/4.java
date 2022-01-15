// Ques - Given a matrix of size r*c. Traverse the matrix in spiral form. 

static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        int total = r*c;
        int minr = 0;
        int maxr = r - 1;
        int minc = 0;
        int maxc = c - 1;
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();        
        
        while(count<total){
            for(int i=minr,j=minc;j<=maxc && count < total;j++){
                res.add(matrix[i][j]);
                count++;
            }
            minr++;
            
            for(int i=minr,j=maxc;i<=maxr && count < total;i++){
                res.add(matrix[i][j]);
                count++;
            }
            maxc--;
            
            for(int i=maxr,j=maxc;j>=minc && count < total;j--){
                res.add(matrix[i][j]);
                count++;
            }
            maxr--;
            
            for(int i=maxr,j=minc;i>=minr && count < total;i--){
                res.add(matrix[i][j]);
                count++;
            }
            minc++;
        }
        
        return res;
    }