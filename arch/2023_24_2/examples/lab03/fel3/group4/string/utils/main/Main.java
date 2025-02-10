package string.utils.main;

import string.utils.IterLetter;

public class Main{
    public static void main(String[] args){
        if (args.length != 2){
            throw new IllegalArgumentException();
        }
        
        IterLetter il = new IterLetter(args[1]);
        
        int n = Integer.parseInt(args[0]);
        
        for (int i = 0; i < n; i++){
            il.printNext();
        }
        
    }
}
