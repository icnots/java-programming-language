package uno.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputSource {
    public final boolean isInteractive;
    private BufferedReader br;

    private int[] inputs;
    private int inputIdx;
    
    public static final int DONE = -1;

    public InputSource(boolean isInteractive, int... inputs) {
        this.isInteractive = isInteractive;
        if (isInteractive) {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        } else {
            this.inputs = inputs;
        }
    }

    public int getNextInput() {
        if (isInteractive) {
            try {
                String input = br.readLine();
                if (input.equals("done"))    return DONE;
                return Integer.parseInt(input)-1;
            } catch (IOException e) {
                return DONE;
            }
        } else {
            if (inputIdx < inputs.length) {
                int input = inputs[inputIdx];
                ++inputIdx;
                return input;
            } else {
                return DONE;
            }
        }
    }
}
