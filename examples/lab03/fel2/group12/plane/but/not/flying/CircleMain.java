package plane.but.not.flying;

import plane.PublicCircle;
import plane.Circle;

public class CircleMain{
    public static void main(String[] args){
        PublicCircle pc = new PublicCircle(0, 0, 1);
        
        System.out.println(pc.getArea());
        pc.x = 5;
        pc.y = 2;
        pc.r = -10;
        
        System.out.println(pc.getArea());
        
        Circle c = Circle();
        
        
        System.out.println(c.getArea());
        c.setX(5);
        c.setY(2);
        c.setR(10);
        System.out.println(c.getArea());
    
    }
}
