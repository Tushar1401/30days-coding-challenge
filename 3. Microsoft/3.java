// Ques - Rotate by 90 degree

static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =  temp;
            }
        }
      
        for(int j=0;j<n;j++){
            int l = 0;
            int r = n - 1;
            while(l<=r){
                int temp = matrix[l][j];
                matrix[l][j] = matrix[r][j];;
                matrix[r][j] = temp;
                l++;
                r--;
            }
        }
    }