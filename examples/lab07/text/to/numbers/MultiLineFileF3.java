package text.to.numbers;

// 3. feladat update-jével

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiLineFileF3{
    public static int addNumbers(String filename, char separator) throws IOException{
        String outFilename = "wrong" + filename;
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
            PrintWriter pw = new PrintWriter(outFilename);
        ){
            String line = br.readLine();
            if (null == line){
                return 0;
            }

            int sum = 0;
            while (null != line){
                String[] numbersText = line.split("" + separator);
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
                
                line = br.readLine();
            }
            
            return sum;
        }catch(IOException e){
            // intentionally throw it
            // other option to leave this catch
            throw e;
        }
    }
}