import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static java.util.Collections.sort;

class Main{
    public static void main(String[] args){
        // működik mindegyik verzió:
        //List<Point> al = new ArrayList<>();
        
        List<Point> al = new LinkedList<>();
        al.add(new Point(3, 5));
        al.add(new Point(3, -5));
        al.add(new Point(3, -9));
        al.add(new Point(3, 17));
        al.add(new Point(13, 5));
        al.add(new Point(13, -5));
        al.add(new Point(13, -9));
        al.add(new Point(13, 17));
        al.add(new Point(-9, 5));
        al.add(new Point(-9, -5));
        al.add(new Point(-9, -9));
        al.add(new Point(-9, 17));
        
        System.out.println(al);
        sort(al);
        System.out.println(al);
        
        // mindenféle objektumot tároló lista:
        LinkedList<Object> ll = new LinkedList<>();
        
        ll.add(Integer.valueOf(12));
        ll.add("Alma");
        ll.add(Double.valueOf(2.7));
        
        System.out.println(ll);
        
        for (Object o : ll){
            if (o.getClass() == Integer.valueOf(1).getClass()){
                Integer i = (Integer)o;
                System.out.println(i+1);
            }else
            if (o.getClass() == Double.valueOf(1.0).getClass()){
                Double d = (Double)o;
                System.out.println(d+1);
            }else{
                System.out.println("Not defined increase.");
            }
        }
    }

}
