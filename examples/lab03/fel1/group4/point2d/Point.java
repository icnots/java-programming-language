package point2d;

public class Point{
    double x, y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;    
    }
    
    public void move(double cx, double cy){
        this.x += cx;
        this.y += cy;
    }

    public void move(Point that){
        this.x += that.x;
        this.y += that.y;
    }
    
    public void print(){
        System.out.println("(" + x + "," + y + ")");
    }
}
