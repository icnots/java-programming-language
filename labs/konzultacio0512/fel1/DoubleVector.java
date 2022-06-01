import static java.util.Objects.hash;

class DoubleVector
{
    double[] coords;

    public DoubleVector(double x1, double x2)
    {
        this.coords = new double[2];
        this.coords[0] = x1;
        this.coords[1] = x2;
    }

    public String toString()
    {
        return "(" + this.coords[0] + "," + this.coords[1] + ")";
    }
    
    @Override
    public int hashCode(){
        return hash(coords[0], coords[1]);
    }
    
    @Override
    public boolean equals(Object thatO){
        if (this == thatO){
            return true;
        }
        if (null == thatO){
            return false;
        }
        if (this.hashCode() != thatO.hashCode()){
            return false;
        }
        if (this.getClass() == thatO.getClass()){
            DoubleVector that = (DoubleVector)thatO;
            
            // ha jól lenne megírva ez a típus:
            /*return (
                this.coords[0] == that.coords[0] 
                && this.coords[1] == that.coords[1]
            );*/
            
            if (that.coords == null){
                return (this.coords == null);
            }else{
                if (this.coords == null){
                    return false;
                }else{
                    return (
                        this.coords[0] == that.coords[0] 
                        && this.coords[1] == that.coords[1]
                    );
                }
            }
            
        }
        return false;
    }
}

