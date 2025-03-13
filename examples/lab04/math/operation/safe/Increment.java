package math.operation.safe;

public class Increment {
    public static int increment(int n){
        return Integer.MAX_VALUE == n ? n : n+1;
    }
}
