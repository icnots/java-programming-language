package plane.but.not.flying;

import plane.PublicCircle;
import plane.Circle;

public class CircleMain{
    public static void main(String[] args){
        PublicCircle pc = new PublicCircle();
        System.out.println(pc.getArea());
        
        pc.x = 5.;
        pc.y = 2.;
        pc.radius = 10.;
        
        System.out.println(pc.getArea());
        
        Circle c = new Circle(0.0, 0.0, 1.0);
        System.out.println(c.getArea());
        c.setX(5.0);
        c.setY(2.);
        c.setRadius(10.);
        System.out.println(c.getArea());
        
        
    }

}


