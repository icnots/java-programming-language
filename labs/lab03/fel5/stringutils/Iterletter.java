package stringutils;

public class Iterletter{
    private int iterator;
    private String data;
    
    public Iterletter(String data){
        if (data == null){
            throw new IllegalArgumentException();
        }
        this.data = data;
        this.iterator = 0;
    }
    public boolean hasNext(){
        return (data.length() > iterator);
    }
    public void printNext(){
        System.out.print(data.charAt(iterator));
        iterator++;
    }
}
