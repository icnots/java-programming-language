package plane;

public class PublicCircle{
    public double x=0, y=0, r=1;
    
    public PublicCircle(double x, double y, double r){
        this.x = x;
        this.y = y;
        if (r <= 0.0){
            throw new IllegalArgumentException();
        }
        this.r = r;
    }
    
    public double getArea(){
        return r * r * Math.PI;
    }
}
