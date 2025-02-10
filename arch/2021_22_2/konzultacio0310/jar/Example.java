import util.Point;

public class Example{
    public static void main(String[] args){
        Point p = new Point(2, 3);
        System.out.println("p: "+p);
    
        p.move(-2, -3);
        System.out.println("p: "+p);
    }

}
