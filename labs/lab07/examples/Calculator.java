public class Calculator{
    public static double power(int base, int pow){
        if (base < 0 || pow < 0){
            throw new IllegalArgumentException();
        }
        
        int res = 1;
        
        for (int i = 0; i < pow; i++){
            res *= base;
        }
        
        return res;
    }

}
