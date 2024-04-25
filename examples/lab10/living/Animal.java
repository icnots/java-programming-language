package living;

import java.util.List;

public abstract class Animal implements Creature{
    protected final int reproduceRate;

    public Animal(int reproduceRate){
        this.reproduceRate = reproduceRate;
    }

    public abstract List<Creature> reproduce();
}