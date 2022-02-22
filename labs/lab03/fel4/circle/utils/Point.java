package circle.utils;

public class Point{

    double x, y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
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
}
