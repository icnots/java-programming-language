package plane;

public class Circle{
    private double x=0, y=0, r=1;
    
    public Circle(){
        return new Circle(0, 0, 1);
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
    public void setR(double value){
        if (value <= 0.0){
            throw new IllegalArgumentException();
        }
        this.r = value;
    } 
    public void setX(double value){
        x = value;
    }    
    public void setY(double value){
        y = value;
    }    
    public double getArea(){
        return r * r * Math.PI;
    }
}
