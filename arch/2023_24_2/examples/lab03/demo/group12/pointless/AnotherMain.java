package pointless;

//import point2d.Point;

public class AnotherMain{
    public static void main(String[] args){
        point2d.Point p = new point2d.Point(2, 3);
        
        p.print();
        
        p.move(0, 5);
        p.print();
    }
}
