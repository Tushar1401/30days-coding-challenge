// Ques - Nuts and bolts problem

void matchPairs(char nuts[], char bolts[], int n) {
    String str = "!#$%&*@^~";
    int p = 0;
    for(int i=0;i<9;i++){
        for(int j=0;j<n;j++){
            if(nuts[j] == str.charAt(i)){
                char temp = nuts[j];
                nuts[j] = nuts[p];
                nuts[p] = temp;
                
                bolts[p] = nuts[p];
             
                p++;
                if(p >= n) break;
            }
        }
    }
}