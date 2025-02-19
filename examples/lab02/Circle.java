public class Circle {
    private double x, y, radius;

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        if (radius > 0.0){
            this.radius = radius;
        }else{
            System.err.println("Radius has to be positive! Radius is set to 1.0");
            this.radius = 1.0;
        }
    }
    
    public void enlarge(double f){
        if (f > 0.0){
            radius *= f;
        }else{
            System.err.println("Scalar has to be positive, radius remains unchanged.");
        }
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
    
    public String toString(){
        return "(" + x + ", " + y + ") r: " + radius;
    }
}
