package pointm.point2d;


class PointMain{
    public static void main(String[] args){
        Point p = new Point(0, 0);
        try{
            p = new Point(-2000000, 0);
        }
        catch (IllegalArgumentException e){
            System.out.println("Exception was thrown in main of PointMain.");
            throw e;
        }
        
        System.out.println("P: " + p);
        
        p.move(3.0, 4.0);        
        System.out.println("P: ("+p.x+","+p.y+")");
        
        Point c = new Point(0, 0);
        c.move (2, 3);
        
        p.mirror(c);
        System.out.println("P: " + p);
        System.out.println("C: ("+c.x+","+c.y+")");
    
        System.out.println("dist.: "+p.distance(c));
        
        int a = 3, b = 4;
        if ( a < b ){
            System.out.println(b-a);
        }else{
            System.out.println(a-b);
        }
        System.out.println(a < b ? b-a : a-b);
    }

}
