interface Printable{
    public void print();
}
abstract class Point{

    double x, y;
    
    Point(double px, double py){
        x = px;
        y = py;
    }
    
    abstract void sumWith(Point p);
    
}

class MyPoint extends Point implements Printable{
    MyPoint(double x, double y){
        super(x, y);
    }
    void sumWith(Point that){
        x += that.y;
        y += that.x;
    }
    public void print(){
        System.out.println("Hello: " + x + " " + y);
    }

}

class MySecondPoint extends Point{
    MySecondPoint(double x, double y){
        super(x, y);
    }
    void sumWith(Point that){
        x += that.x;
        y += that.y;
    }
}

class PointMain{
    public static void main(String[] args){
        Point p = new MyPoint(1.2, 3.5);
        Point p2 = new MySecondPoint(7.6, 3.8);
        
        Printable p3 = new MyPoint(1.2, 3.5);
    
    }

}
