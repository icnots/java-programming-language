package geo.point2d;

public class Point{
    private double x;
    public double y;
    public void move(double dx, double dy){
        if (dx > 100){
            throw new IllegalArgumentException("dx is over 100");
        }
        
        x += dx;
        y += dy;
    }
    public void mirror(Point c){
        x = 2 * c.x - x;
        y = 2 * c.y - y;
    }
    public double distance(Point p){
        return Math.sqrt(
            (x - p.x) * (x - p.x) +
            (y - p.y) * (y - p.y)
        );
    }
    
    
    public void setX(double x){
        this.x = x;
    }
    public double getX(){
        return this.x;
    }
}
