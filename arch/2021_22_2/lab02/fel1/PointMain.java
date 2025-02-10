class PointMain{
    public static void main(String[] args){
        Point p = new Point();
        System.out.println("("+p.x+","+p.y+")");
        
        p.move(3.0, 4.0);        
        System.out.println("("+p.x+","+p.y+")");
            
        p.mirror(2.0, 3.0);        
        System.out.println("("+p.x+","+p.y+")");
    
    }

}
