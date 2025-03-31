package text.to.numbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SingleLineFile{
    public static int addNumbers(String filename) throws IOException{
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ){
            String line = br.readLine();
            if (null == line){
                throw new IllegalArgumentException("Empty file");
            }

            int sum = 0;
            String[] numbersText = line.split(" ");
            for (String numberText : numbersText){
                try{
                    int num = Integer.parseInt(numberText);
                    sum += num;
                }
                catch(NumberFormatException e){
                    System.err.println(numberText);
                }
            }
            
            return sum;
        }catch(IOException e){
            // intentionally throw it
            // other option to leave this catch
            throw e;
        }
    }
}
