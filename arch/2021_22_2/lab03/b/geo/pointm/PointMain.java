package geo.pointm;

import geo.point2d.Point;

class PointMain{
    public static void main(String[] args){
        Point p = new Point();
        System.out.println("P: ("+p.getX()+","+p.y+")");
        
        p.move(3.0, 4.0);    
        
        try {
            p.move(1003.0, 4.0);   
        }
        catch (IllegalArgumentException e){
            System.out.println("move was not succesfull.");
        }
        
               
        System.out.println("P: ("+p.getX()+","+p.y+")");
        
        Point c = new Point();
        c.move (2, 3);
        
        p.mirror(c);        
        System.out.println("P: ("+p.getX()+","+p.y+")");
        System.out.println("C: ("+c.getX()+","+c.y+")");
    
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
