public class Point {
    private double x, y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
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
    
    public void mirror(Point center){
        x = 2 * center.x - x;
        y = 2 * center.y - y;
    }
    
    public double abs(){
        return Math.sqrt(x*x+y+y);
    }
    
    public double distance(Point that){
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        
        // egy ötlet:
        return new Point(dx, dy).abs();
    }
    
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
