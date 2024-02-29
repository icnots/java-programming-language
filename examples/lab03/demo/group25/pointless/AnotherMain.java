package pointless;

public class AnotherMain{
    public static void main(String[] args){
        if (args.length > 0){
            throw new IllegalArgumentException();
        }
    
        point2d.PointMain.main(args);
    }
}
