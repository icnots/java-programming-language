package string.utils;

public class IterLetter{
    private String str;
    private int counter;
    
    public IterLetter(String str){
        counter = 0;
        if (str == null){
            throw new IllegalArgumentException();
        }else{
            this.str = str;
        }     
    }
    
    public boolean hasNext(){
        return counter < str.length;
    }
    
    public void reset(){
        counter = 0;
    }
    
    public void printNext(){
        System.out.println(str.charAt(counter));
        counter++;
    }
}
