public class PrintHalves {
    public static void main(String[] args) {
        int start = Integer.parseInt(System.console().readLine());
        int finish = Integer.parseInt(System.console().readLine());
    
        for(int i = start; i <= finish; i++) {
            System.out.println(i/2.);
        }
        int amount = finish-start+1;
        System.out.println("Kiirtam " + amount + " szamot");
    }
}

