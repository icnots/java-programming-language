package data;

public class Bus extends Car{
    protected final int seats;

    public int getSeats(){
        return seats;
    }

    public Bus(String color, String brand, int weight, int seats){
        super(color, brand, weight);

        this.seats = seats;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", seats:");
        sb.append(seats);

        return sb.toString();
    }
}