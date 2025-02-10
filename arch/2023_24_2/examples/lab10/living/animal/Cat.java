package living.animal;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import living.Animal;
import living.Creature;

public class Cat extends Animal{
    private static final int defaultReproduceRate = 3;

    public Cat(int reproduceRate){
        super(reproduceRate);
    }

    public Cat(){
        this(defaultReproduceRate);
    }

    public void meow(){
        System.out.println("Meow");
    }

    public List<Creature> reproduce(){
        Random random = new Random();  
        List<Creature> descendants = new ArrayList<>(reproduceRate);

        for (int i = 0; i < reproduceRate; i++){
            int newRate = Math.max(0, reproduceRate + random.nextInt(3) -1 );
            descendants.add(new Cat(newRate));
        }

        return descendants;
    }
}