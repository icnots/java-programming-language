package data;

public class Van extends Car{
    protected final int length;

    public int getLength(){
        return length;
    }

    public Van(String color, String brand, int weight, int length){
        super(color, brand, weight);

        this.length = length;
    }

    public Van(){
        this("black", "VW", 2200, 5500);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", length:");
        sb.append(length);

        return sb.toString();
    }
}