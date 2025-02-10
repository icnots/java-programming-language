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
    
    public static void main( String[] args ){
        Point p = new Point(5, 4);
        
        p.y = 13;
        
        System.out.println("p: "+p);
    }
    
}
