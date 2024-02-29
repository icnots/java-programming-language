public class Fakt{
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.println("fakt("+i+") = "+fakt(i));
        }
    
    }
    
    public static int fakt(int n){
        if (n < 2){
            return 1;
        }else{
            return n * fakt(n-1);
        }
    }
}
