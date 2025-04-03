import java.util.HashSet;

public class Main{
    public static void main(String[] args){
        HashSet<String> words = new HashSet<String>();

        for (String word : args){
            words.add(word);
        }

        for (String word : words){
            System.out.println(word);
        }
    }
}