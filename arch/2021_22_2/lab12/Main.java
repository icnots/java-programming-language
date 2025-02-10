import java.util.Objects;
import java.util.Iterator;

class Main{

    public static void main(String[] args){
        Point p = new Point();
        p.x = 1;
        p.y = 2;
        
        for (Integer i : p){
            //dffdf
            System.out.println(i);
        }
        
        Iterator<Integer> it = p.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            
            //dffdf
            System.out.println(i);
        }
    }
}

class A{
    Point p;
    int j;
    
    int id = nextId++;
    static int nextId = 0;
    
    @Override
    public boolean equals(Object that){
        if (this == that)
            return true;
        else if (that == null){
            return false;
        }
        else if (this.getClass() == that.getClass()){
            A thatA = (A)that;
            if (thatA.j == this.j){
                if (this.p != null){
                    return this.p.equals(thatA.p);
                }else{
                    return thatA.p == null;
                }
            
            }
        
        }
        return false;
    
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.p.hashCode(), j);
    }
    
}

class Point implements Comparable, Iterable<Integer>{
    int x, y;
    
    public int compareTo(Object thatObject){
        if (this.getClass() != thatObject.getClass()){
            throw new IllegalArgumentException();
        }
        Point that = (Point)thatObject;
    
        if (this.x < that.x){
            return -1;
        }else if (this.x > that.x){
            return 1;
        }else{
            return this.y - that.y;
        }
    }
    
    public Iterator<Integer> iterator(){
        return new PointIterator(this);
    
    }
}

class PointIterator implements Iterator<Integer>{
    Point p;
    int counter = 0;
    PointIterator(Point p){
        this.p = p;
    }
    
    public boolean hasNext(){
        return (counter < 2);
    }
    
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
