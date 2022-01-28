// Ques - Generate Random Point in a Circle


    // In mathematics if a circle with centre (a,b) and radius R then the equation -
    // (x - a)^2 + (y - b)^2 < R*R 
    // then any point (x,y) following this equation will lie inside the circle
    
    // Range of X Cordinate = (a - R,a + R)
    // Range of Y Cordinate = (b - R,b + R)
    
    double a, b, r;
    public Solution(double radius, double x_center, double y_center) {
        this.a = x_center;
        this.b = y_center;
        this.r = radius;
    }
    
    public double[] randPoint() {
        double minx = a - r;
        double maxx = a + r;
        double miny = b - r;
        double maxy = b + r;
        
        double[] res = new double[2];
        res[0] = (Math.random()*(maxx - minx)) + minx;
        res[1] = (Math.random()*(maxy - miny)) + miny;
        
        while(getDistance(res[0],res[1]) >= r*r){
            res[0] = (Math.random()*(maxx - minx)) + minx;
            res[1] = (Math.random()*(maxy - miny)) + miny;
        }
        
        return res;
    }
    
    private double getDistance(double x, double y){
        return (x - a)*(x - a) + (y - b)*(y - b);
    }