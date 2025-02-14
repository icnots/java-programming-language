public class Calculator {
    public static void main(String[] args) {
        if (args.length != 2){
            System.err.println("Please, provide 2 arguments!");
            return;
        }

        int fst = Integer.parseInt(args[0]);
        int snd = Integer.parseInt(args[1]);
        
        System.out.println("Sum: " + (fst+snd));
        System.out.println("Diff: " + (snd-fst));
        System.out.println("Prod: " + (fst*snd));
        if (snd == 0){
            System.out.println("Division by zero");
        }else{
            System.out.println("Quotient as int: " + (fst / snd));
            System.out.println("Quotient as int: " + (fst / (double)snd));
            System.out.println("Residual: " + (fst % snd));
        }
    }
}