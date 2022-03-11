package util;

public class Point{
    private double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }
    
    public String toString(){
        return x + "," + y;
    }
    
}
