package rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CarRental{
    private ArrayList<Car> cars;

    public CarRental(String filename){
        cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            for (String line = br.readLine(); line != null; line = br.readLine()){
                String[] parts1 = line.split(":");
                if (2 == parts1.length){
                    String brand = parts1[0];
                    String[] parts2 = parts1[1].split(",");
                    if (2 == parts2.length){
                        String licensePlate = parts2[0];
                        double price;
                        try {
                            price = Double.parseDouble(parts2[1]);
                        }
                        catch(NumberFormatException e){
                            price = -1.0;
                        }

                        Car c = Car.make(brand, licensePlate, price);
                        if (null != c){
                            cars.add(c);
                        }
                    }
                }
            }
        }catch(IOException e){
            //System.err.println("Not valid filename");
        }
    }

    public int numberOfCars(){
        return cars.size();
    }

    public void insertionSort(){
        int length = cars.size();
        List<Car> newCars = new ArrayList<>(length); // to have enough spaces from the beginning


        for (Car car : cars){
            int index = search(newCars, car);
            newCars.add(index, car);
        }

        cars = new ArrayList<>(newCars);
    }

    private int search(List<Car> cars, Car car){
        for (int i = 0; i < cars.size(); i++){
            if (car.isCheaperThan(cars.get(i))){
                return i;
            }
        }
        return cars.size();
    }

    public double weightedAverage(){
        if (cars.isEmpty()){
            return -1.0;
        }

        double sum = 0.0;
        int length = cars.size();
        for (int i = 0; i < length; i++){
            sum += (i+1) * cars.get(i).getPrice();
        }

        int weight = length * (length+1) / 2;
        return sum / weight;
    }

    public Car rentCheapest(){
        if (cars.isEmpty()){
            return null;
        }else{
            insertionSort();
            return cars.removeFirst();
        }
    }

    public ArrayList<Car> sale(){
		Random rand = new Random();
		ArrayList<Car> result = new ArrayList<>();
		for (Car car : cars) {
		    if (rand.nextBoolean())    car.decreasePrice();
		    result.add(car);
        }
		return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Car c : cars){
            sb.append(c.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}