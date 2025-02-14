public class PrintHalves {
    public static void main(String[] args) {
        if (args.length != 2){
            System.err.println("Please, provide 2 arguments!");
            return;
        }

        int fst = Integer.parseInt(args[0]);
        int snd = Integer.parseInt(args[1]);
        
        for(int i = fst; i <= snd; i++) {
            System.out.println(i/2.);
        }
        System.out.println("Kiirtam " + (snd-fst+1) + " szamot");
    }
}
