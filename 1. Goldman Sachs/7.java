// Ques - Find the kid which gets tha damaged toy

// n -> total no. of kids
// m -> total no. of toys
// k -> starting position

static int lastPosition(int n, int m, int k) {
    int res = (k + m - 1) % n;
    if (n == 0)
        return n;
    return res;
}
