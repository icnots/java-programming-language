import util.Point;

public class Main{
    public static void main(String[] args){
        Point p = new Point(12, 13);
        System.out.println("p: "+p);
    
        p.move(-2, 3);
        System.out.println("p: "+p);
    }

}
