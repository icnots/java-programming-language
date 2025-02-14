public class Welcome {
    public static void main(String[] args){
        System.console().printf("What is your name?\n");
        String name = System.console().readLine();

        System.console().printf("Hello, %s!\n", name);
    }
}