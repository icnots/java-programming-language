package textfile.lookup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContent {
    public static int[] contentLineNumbers(String filename, String content) {
        int count = contentLineCount(filename, content);
        int[] lineNumbers = new int[count];

        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            int counter = 0;
            int lineIdx = 1;
            while (true) {
                String line = br.readLine();
                if (line == null)   break;

                lineIdx += 1;

                if (!line.contains(content)) continue;

                lineNumbers[counter] = lineIdx-1;
                counter += 1;
            }
        } catch (IOException e) {
            return new int[0];
        }

        return lineNumbers;
    }

    public static int contentLineCount(String filename, String content) {
        int lineNumbers = 0;
        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));
        ) {
            while (true) {
                String line = br.readLine();
                if (line == null)   break;
                if (line.contains(content)){
                    lineNumbers += 1;
                }
            }
        } catch (IOException e) {
            return 0;
        }

        return lineNumbers;
    }
}
