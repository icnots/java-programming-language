package data;

public class Car implements Vehicle{
    protected final String color;
    protected final String brand;
    protected final int weight;

    @Override
    public String getColor(){
        return color;
    }
    @Override
    public String getBrand(){
        return brand;
    }
    @Override
    public int getWeight(){
        return weight;
    }

    public Car(String color, String brand, int weight){
        this.color = color;
        this.brand = brand;
        this.weight = weight;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(brand);
        sb.append(":");
        sb.append(color);
        sb.append(", weight:");
        sb.append(weight);

        return sb.toString();
    }
}