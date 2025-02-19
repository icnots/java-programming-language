public class PointMain {
    public static void main(String[] args){
        Point p1 = new Point(1.0, 2.0);
        
        System.out.println(p1.toString());
        
        p1.move(0.0, 1.0);
        
        System.out.println(p1.toString());
        
        p1.mirror(2.0, 1.1);
        
        System.out.println(p1);
        
        Point p2 = new Point(0., 0.);
        Point p3 = new Point(-2., 1.);
        
        p2.mirror(p3);
        System.out.println(p2);
        
        Point origo = new Point(0., 0.);
        System.out.println(p3.distance(origo) + " =?= " + p3.abs());
    }
}
