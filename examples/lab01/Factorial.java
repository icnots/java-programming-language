public class Factorial {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            int n = Integer.parseInt(args[i]);

            System.out.println(n + "! = " + factorial(n));
        }
    }

    public static int factorial(int n){
        if (n < 2){
            if (n < 0){
                System.err.println("Negative value: " + n + " => factorial returns 1");
            }
            return 1;
        }else{
            int res = 1;
            for (int i = 2; i <= n; i++){
                res *= i;
            }
            return res;
        }
    }
}