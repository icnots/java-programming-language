package point2d;

class Point {
    private double x, y;
    
    public double getX(){
        return x;
    }
    public void setX(double x){
        if (x > 1000000){
            throw new IllegalArgumentException();
        }
        this.x = x;
    }    
    public double getY(){
        return y;
    }
    public void setY(double y){
        if (y > 1000000){
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

    public Point(){
        x = 0.0;
        y = 0.0;
    }

    public Point(double x, double py){
        setX(x);
        setY(y);
    }
    
    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }
    
    public void mirror(double cx, double cy){
        x = 2*cx - x;
        this.y = 2*cy - this.y;
    }
    
    public String toString(){
        return "("+x+","+y+")";
    }
}
