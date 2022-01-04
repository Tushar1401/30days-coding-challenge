// Ques - Find total number of Squares in a N*N chessboard

import java.util.*;
public class Main {

	public static void main(String args[]) {
	    int n = 8;
	    int count = 0;
	    
	    // for(int i=1;i<=n;i++){
	    //     count += (i*i);
	    // }
	    
        // ------ OR -------
        count = n*(n + 1)*(2*n + 1) / 6;
        
	    System.out.println(count);
	}
}