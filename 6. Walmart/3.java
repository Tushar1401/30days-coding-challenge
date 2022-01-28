// Ques - Remove Colored Pieces if Both Neighbors are the Same Color

public boolean winnerOfGame(String colors) {
    int alice = 0;
    int bob = 0;
    
    for(int i=1;i<colors.length() - 1;i++){
        char prev = colors.charAt(i - 1);
        char curr = colors.charAt(i);
        char next = colors.charAt(i + 1);
        
        if(curr == 'A'){
            if(prev == 'A' && next == 'A'){
                alice++;
            }
        }else{
            if(prev == 'B' && next == 'B'){
                bob++;
            }
        }
    }
    
    return alice > bob ? true : false;
}