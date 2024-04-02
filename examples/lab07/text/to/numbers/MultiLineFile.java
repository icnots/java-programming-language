package text.to.numbers;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MultiLineFile{
    public static int addNumbers(String filename, char separator) throws IOException {
        int sum = 0;
        String line;
        try(
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ){
            while (null != (line = br.readLine())){
                String[] numbersAsString = line.split(String.valueOf(separator));
                for (String numberAsString : numbersAsString){
                    try{
                        sum += Integer.parseInt(numberAsString);
                    }
                    catch (NumberFormatException e){
                        System.err.println(numberAsString);
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        try {
            addNumbers("multiLineSpace.txt", ' ');
        }catch (Exception e){
            // intentionally nothing
        }
    }
}