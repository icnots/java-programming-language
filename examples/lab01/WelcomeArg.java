public class WelcomeArg {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            String name = args[i];

            System.out.println("Hello, " + name + "!");
        }
    }
}