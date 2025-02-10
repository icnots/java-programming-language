package living.animal;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import living.Animal;
import living.Creature;

public class Dog extends Animal{
    private static final int defaultReproduceRate = 2;

    public Dog(int reproduceRate){
        super(reproduceRate);
    }

    public Dog(){
        this(defaultReproduceRate);
    }

    public void bark(){
        System.out.println("Bark");
    }

    public List<Creature> reproduce(){
        Random random = new Random();  
        List<Creature> descendants = new ArrayList<>(reproduceRate);

        for (int i = 0; i < reproduceRate; i++){
            int newRate = Math.max(0, reproduceRate + random.nextInt(3) -1 );
            descendants.add(new Dog(newRate));
        }

        return descendants;
    }
}