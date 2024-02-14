package pointm.point2d;

class Point{
    double x, y;
    
    Point(double x, double y){
        this.x = x;
        this.y = y;
        
        if ( x < -1000000 ){
            throw new IllegalArgumentException("x is less than -1000000.");
        }
    }
    
    void move(double dx, double dy){
        x += dx;
        y += dy;
    }
    void mirror(Point c){
        x = 2 * c.x - x;
        y = 2 * c.y - y;
    }
    double distance(Point p){
        return Math.sqrt(
            (x - p.x) * (x - p.x) +
            (y - p.y) * (y - p.y)
        );
    }
    
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }
}
