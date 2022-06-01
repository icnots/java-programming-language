class Point implements Comparable<Point> {
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
    
    @Override
    public int compareTo(Point that){
        // lexikografikus rendezés:
        //  this.x == that.x => megvizsgálom this.y és that.y értékeket:
        //    this.y <  that.y => this kisebb  => negatív szám a visszatérési érték
        //    this.y >  that.y => this nagyobb => pozitív szám a visszatérési érték
        //    this.y == that.y => 0 lesz a visszatérési érték
        //  this.x < that.x => this kisebb  => negatív szám a visszatérési érték
        //  this.x > that.x => this nagyobb => pozitív szám a visszatérési érték
        if (this.x == that.x){
            return this.y - that.y;
        }else{
            return this.x - that.x;
        }
        
    }

}
