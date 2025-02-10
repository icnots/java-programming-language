public class Circle{
    private double x = 0.0, y = 0.0, r = 1.0;
    
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setR(double r){
        if (r <= 0.0){
            throw new IllegalArgumentException();
        }
        this.r = r;
    }
    public Circle(double x, double y, double r){
        setX(x);
        setY(y);
        setR(r);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getR(){
        return r;
    }
}
