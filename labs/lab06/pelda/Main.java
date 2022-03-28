
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;


class Main{
    public static void main(String[] args){
        try (
            BufferedReader br = new BufferedReader(new FileReader("in.txt"));
            FileWriter fw = new FileWriter("out.txt");
        ) {
            String s;
            while ( null != (s = br.readLine()) ){
                fw.write(s);
                fw.write(s);
                fw.write("\n");
            }
        }
        catch(Exception e){
        }
    }

}
