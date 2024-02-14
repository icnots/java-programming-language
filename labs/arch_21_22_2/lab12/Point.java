import java.util.Objects;
import java.util.Iterator;

class Sarkany{}
class Point implements Comparable<Point>, Iterable<Integer>{
    public static void main(String[] args){
        Point p = new Point();
        p.x = 1;
        p.y = 2;
        
        for (Integer i : p){
            // dfgh
            System.out.println(i);
        }
        
        Iterator<Integer> it = p.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            
            // dfgh
            System.out.println(i);
        }
        
    }


    int x, y;
    Sarkany s;
    
    @Override
    public boolean equals(Object thatO){
        if (this == thatO){
            return true;
        }else if (thatO == null){
            return false;
        }else{
            if (thatO.getClass() == this.getClass()){
                Point that = (Point) thatO;
                if (this.s == null){
                    if (that.s == null){
                        return this.x == that.x && this.y == that.y;
                    }else
                        return false;
                }else{
                
                    return this.s.equals(that.s) && this.x == that.x && this.y == that.y;
                }
            }else{
                return false;
            }
        }
    
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
    
    // this - that értékét adja vissza
    @Override
    public int compareTo(Point that){        
        if (this.x == that.x){
            return this.y - that.y;
        }else{
            return this.x - that.x;
        }
    }
    
    @Override
    public Iterator<Integer> iterator(){
        return new PointIterator(this);
    }
}

class PointIterator implements Iterator<Integer>{
    Point p;
    int counter;
    PointIterator(Point p){
        this.p = p;
        counter = 0;
    }
    
    @Override
    public boolean hasNext(){
        return counter < 2;
    }
    @Override
    public Integer next(){
        if (counter == 0){
            counter++;
            return p.x;
        }else if (counter == 1){
            counter++;
            return p.y;
        }else{
            throw new NullPointerException();
        }
    }
}
