public class CircleMain{
    public static void main(String[] args){
        Circle c1 = new Circle(2.0, 3.0, 5.0);
        
        System.out.println("c1: " + c1);
        System.out.println("Area of the circle: " + c1.getArea());
        
        c1.enlarge(2.0);
        System.out.println("Enlargement by 2.0");
        
        System.out.println("Area of the circle: " + c1.getArea());
        
        System.out.println("Trying to create a circle with radius -1.0:");
        Circle c2 = new Circle(0.0, 0.0, -1.0);
        
        System.out.println("c1: " + c1);
        
        System.out.println("Trying to enlarge c1 by -2.0");
        
        c1.enlarge(-2.0);
        System.out.println("c1: " + c1);
    }
}
