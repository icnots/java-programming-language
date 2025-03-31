package textfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Statistics{
    public static int numberOfCharacters(String filename){
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ){
            int numberOfChars = 0;

            String line = br.readLine();
            while (null != line){
                numberOfChars += line.length();

                line = br.readLine();
            }
            
            return numberOfChars;
        }catch(IOException e){
            return 0;
        }
    }

    public static int numberOfLines(String filename){
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ){
            int numberOfLines = 0;

            String line = br.readLine();
            while (null != line){
                numberOfLines += 1;

                line = br.readLine();
            }
            
            return numberOfLines;
        }catch(IOException e){
            return 0;
        }
    }
}