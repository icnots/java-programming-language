public class Point {
    private double x, y;
    
    public Point(double px, double py){
        x = px;
        y = py;
    }
    
    public void move(double dx, double dy){
        x += dx;
        // same as this.x += dx;
        y += dy;
        // same as this.y += dy;
    }
    
    public void mirror(double cx, double cy){
        this.x = 2*cx - this.x;
        this.y = 2*cy - this.y;
    }
    
    public void printData(){
        System.out.println("(" + x + "," + y + ")");
    }
}
