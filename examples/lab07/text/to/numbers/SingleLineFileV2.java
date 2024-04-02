package text.to.numbers;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SingleLineFileV2{
    public static int addNumbers(String filename) throws IOException {
        String errFilename = "wrong." + filename;
        
        try(
            BufferedReader br = new BufferedReader(new FileReader(filename));
            PrintWriter pw = new PrintWriter(errFilename);
        ){
            String line = br.readLine();
            if (line == null){
                throw new IllegalArgumentException("Empty file");

            }

            String[] numbersAsString = line.split(" ");
            int sum = 0;
            for (String numberAsString : numbersAsString){
                try{
                    sum += Integer.parseInt(numberAsString);
                }
                catch (NumberFormatException e){
                    System.err.println(numberAsString);
                    pw.println(numberAsString);
                }
            }
            return sum;
        }
    }

    public static void main(String[] args){
        try {
            addNumbers("SingleLineFile.java");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}