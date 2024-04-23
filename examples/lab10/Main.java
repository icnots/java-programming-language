import java.util.ArrayList;

import data.Vehicle;
import data.*;

public class Main{
    public static void main(String[] args){
        ArrayList<Vehicle> list = new ArrayList<>();

        list.add(new Car("red", "Ferrari", 861));
        list.add(new Van("white", "Renault", 1990, 6000));
        list.add(new Van());
        list.add(new Bus("yellow", "Ikarus", 12500, 41));

        for (Vehicle vehicle : list){
            System.out.println(vehicle);
        }
    }
}