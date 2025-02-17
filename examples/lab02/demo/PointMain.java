public class PointMain {
    public static void main(String[] args){
        Point p1 = new Point(1.0, 2.0);
        
        p1.printData();
        
        p1.move(0.0, 1.0);
        
        p1.printData();
        
        p1.mirror(2.0, 1.1);
        
        p1.printData();
    }
}
