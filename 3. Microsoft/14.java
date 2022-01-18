// Ques - Given a destination D , find the minimum number of steps required to reach that destination.

static int minSteps(int D){
    D = Math.abs(D);
    int steps = 0, sum = 0;
    
    while(sum < D){
        sum += steps;
        steps++;
    }
    
    while((sum - D) % 2 == 1){
        sum += steps;
        steps++;
    }
    
    return steps - 1;
}