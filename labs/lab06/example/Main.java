import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;


class Main{
    public static void main(String[] args){
        
        try (
            BufferedReader br = new BufferedReader(new FileReader("in.txt"));
            PrintWriter pw = new PrintWriter("output.txt");
        ){
            String s;
            
            while (null != (s = br.readLine())){
                String[] ns = s.split(",");
                int sum = 0;
                for (String n : ns){
                    sum += Integer.parseInt(n);
                }
                pw.println(sum);
            }
            
        }
        catch(Exception e){
            
        }
    }


}



class Apple{
    String name;
    
    /* rossz megoldás */
    static String getName(Apple a){
        return a.name;
    }
    /* jó megoldás */
    String getName(){
        return name;
    }
/*
    Apple.getName(a);
    a.getName();
*/
}
