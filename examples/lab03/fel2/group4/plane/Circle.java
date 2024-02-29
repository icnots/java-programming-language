package plane;

public class Circle{
    private double x=0.0, y=0.0, radius=1.0;
    
    public double getX(){return x;}
    public double getY(){return y;}
    public double getRadius(){return radius;}
    
    public Circle(double x, double y, double r){
        setX(x);
        setY(y);
        setRadius(r);
    }
    
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setRadius(double radius){
        if (radius <= 0.0){
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }

}
