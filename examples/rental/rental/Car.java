package rental;

public class Car{
    private String brand;
    private String licensePlate;
    private double price;

    public double getPrice(){
        return price;
    }

    private static final double MAX_PRICE = 500.0;
    private static final Car CAR_OF_THE_YEAR = new Car("Alfa Romeo", "ABC 123", MAX_PRICE);

    private Car(String brand, String licensePlate, double price){
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.price = price;
    }

    public boolean isCheaperThan(Car other){
        return this.price < other.price;
    }

    public void decreasePrice(){
        if (!Double.valueOf(MAX_PRICE).equals(price) && price > 10.0){
            price -= 10.0;
        }
    }

    public static Car make(String brand, String licensePlate, double price){
        if (isValidBrand(brand) && isValidLicensePlate(licensePlate) && isValidPrice(price)){
            return new Car(brand, licensePlate, price);
        }
        return null;
    }

    private static boolean isValidBrand(String brand){
        int length = brand.length();
        if (length <= 2){
            return false;
        }
        for (int i = 0; i < length; i++){
            if (
                !Character.isLetter(brand.charAt(i))
                &&
                !Character.isWhitespace(brand.charAt(i))
            ){
                return false;
            }
        }

        return true;
    }
    private static boolean isValidLicensePlate(String licensePlate){
        if (licensePlate.length() != 7){
            return false;
        }

        for (int i = 0; i < 3; i++){
            if (
                !Character.isUpperCase(licensePlate.charAt(i))
                ||
                !Character.isDigit(licensePlate.charAt(i+4))
            ){
                return false;
            }
        }
        if (' ' != licensePlate.charAt(3)){
            return false;
        }

        return true;
    }
    private static boolean isValidPrice(double price){
        return 0 < price && price <= MAX_PRICE;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(brand);
        sb.append(" (");
        sb.append(licensePlate);
        sb.append(")");
        sb.append(" %5.1f".formatted(price));
        sb.append(" EUR");
        return sb.toString();
    }
}