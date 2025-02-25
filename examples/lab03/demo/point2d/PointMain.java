package point2d;

public class PointMain {
    public static void main(String[] args){
        Point p = new Point(2., 1.);
        
        System.out.println(p.toString());
        p.setX(10.0);
        p.move(1., 0.0);
        
        System.out.println(p.toString());
        
        p.mirror(0.0, 0.0);

        System.out.println(p);
    }

}
