package point2d;

public class PointMain{
    public static void main(String[] args){
        if (args.length > 0){
            throw new IllegalArgumentException();
            //throw new IllegalArgumentException("Ne adj meg parancssori argumentumot");
        }
        
        Point p = new Point(2, 3);
        
        p.print();
        
        p.move(0, 5);
        p.print();
    }
}
