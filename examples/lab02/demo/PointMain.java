public class PointMain {
    public static void main(String[] args){
        Point p1 = new Point(1.0, 2.0);
        
        System.out.println(p1.toString());
        
        p1.move(0.0, 1.0);
        
        System.out.println(p1.toString());
        
        p1.mirror(2.0, 1.1);
        
        System.out.println(p1);
    }
}
