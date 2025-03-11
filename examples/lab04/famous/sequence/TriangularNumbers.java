package famous.sequence;

public class TriangularNumbers{
    public static int getTriangularNumber(int n){
        int sum = 0;
        for (int i = 0; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static int getTriangularNumberAlternative(int n){
        if (n < 1){
            return 0;
        }else{
            return n * (n+1) / 2;
        }
    }
}