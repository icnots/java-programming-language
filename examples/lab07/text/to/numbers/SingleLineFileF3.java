package text.to.numbers;

// 3. feladat update-jével

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SingleLineFileF3{
    public static int addNumbers(String filename) throws IOException{
        String outFilename = "wrong" + filename;
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
            PrintWriter pw = new PrintWriter(outFilename);
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
                    pw.println(numberText);
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
