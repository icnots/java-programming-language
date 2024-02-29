package string.utils;

public class IterLetter{
    private String s;
    private int counter;

    public IterLetter(String s){
        if (null == s){
            throw new IllegalArgumentException();
        }
        this.s = s;
        reset();
    }
    
    public void printNext(){
        if (counter < s.length()){
            System.out.println(s.charAt(counter));
            counter++;
        }else{
            System.out.println();
        }
    }
    
    public void reset(){
        counter = 0;
    }

}
