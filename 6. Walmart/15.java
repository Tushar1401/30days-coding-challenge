// Ques - Divide two Integers

public int divide(int dividend, int divisor) {
    if(dividend == 1<<31 && divisor == -1) return Integer.MAX_VALUE;
    
    boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
    
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    
    int res = 0;
    while(dividend - divisor >= 0){
        int count = 0;
        while(dividend - (divisor << 1 <<count) >= 0){ // divisor gets doubled every time
            count++;
        }
        res += (1<<count); // we are doubling the divisor so count should be double of what we counted
        dividend -= divisor << count;
    }
    
    return sign ? res : -res;
}