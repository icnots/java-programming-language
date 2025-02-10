package textfile;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Statistics{
    public static int numberOfCharacters(String filename){
        String line;
        int chars = 0;

        try (
            BufferedReader br = new BufferedReader(new FileReader(filename))
        ){
            while (null != (line = br.readLine())){
                chars += line.length();
            }
        } catch (IOException e){}

        return chars;
    }

    public static int numberOfLines(String filename){
        String line;
        int lines = 0;

        try (
            BufferedReader br = new BufferedReader(new FileReader(filename))
        ){
            while (null != (line = br.readLine())){
                lines++;
            }
        } catch (IOException e){}
        
        return lines;
    }
}