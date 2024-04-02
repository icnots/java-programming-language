package textfile.lookup;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileContent{
    public static int contentLineCount(String filename, String content){
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename))
        ){
            String line;
            int counter = 0;

            while (null != (line = br.readLine())){
                if (line.contains(content)){
                    counter++;
                }
            }

            return counter;
        } catch (IOException e){
            return 0;
        }
    }

    public static int[] contentLineNumbers(String filename, String content){
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename))
        ){
            String line;
            int[] occurrences = new int[contentLineCount(filename, content)];
            int counter = 0;
            int lineCounter = 0;

            while (null != (line = br.readLine())){
                if (line.contains(content)){
                    occurrences[counter++] = lineCounter;
                }
                lineCounter++;
            }

            return occurrences;
        } catch (IOException e){
            return new int[0];
        }
    }
}