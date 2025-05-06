import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Iterator;

class ZooIterator implements Iterator<Animal>{
    private List<Animal> innerData;
    private int counter;

    ZooIterator(List<Animal> list){
        innerData = new ArrayList<>(list);
        counter = 0;
    }

    @Override
    public boolean hasNext(){
        return counter < innerData.size();
    }

    @Override
    public Animal next(){
        return innerData.get(counter++);
    }
}

class Zoo implements Iterable<Animal>{
    private List<Animal> list = new LinkedList<>();

    @Override
    public Iterator<Animal> iterator(){
        return new ZooIterator(list);
    }

    public void add(Animal animal){
        list.add(animal);
    }
}


interface Animal{
    public abstract void shout();
    public default void step(){
        System.out.print("A step is made by");
    }
}

class Dog extends Object implements Animal{
    @Override
    public void shout(){
        System.out.println("Dog is shouting.");
    }
    @Override
    public void step(){
        Animal.super.step();
        System.out.println(" a dog.");
    }
}
class Cat implements Animal, Comparable<Cat>{
    //public/protected/0/private static/0 final/0 abstract/default/0 returnType funcName(ParamType1 p1) throws MyException {}/;

    @Override
    public void shout(){
        System.out.println("Cat is shouting.");
    }
    @Override
    public void step(){
        Animal.super.step();
        System.out.println(" a cat.");
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (this.hashCode() != obj.hashCode()){
            return false;
        }

        if (this.getClass().equals(obj.getClass())){
            Cat c = (Cat)obj;
            return true;
        }

        if (obj instanceof Cat c){
            //Cat c = (Cat)obj;

            //return this.member == c.member;
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(/* belső állapotra jellemző mezők */);
        //return 1;
    }
    @Override
    public int compareTo(Cat that){
        /* this > that */
        //return +1; // positive
        /* this == that */
        return 0;
        /* this < that */
        //return -1; // negative
    }
}

public class Main1600{
    public static void main(String[] args){
        Zoo zoo = new Zoo();

        zoo.add(new Dog());
        zoo.add(new Dog());
        zoo.add(new Cat());
        zoo.add(new Cat());

        for (Animal animal : zoo){
            // anything
            animal.step();
            animal.shout();
        }

        Iterator<Animal> it = zoo.iterator();
        while(it.hasNext()){
            Animal animal = it.next();

            // anything
        }

        double d1 = 1.0, d2 = 0.6;

        if (Double.valueOf(d1).equals(d2)){
            double[] mytomb1;
            double[] mytomb2;
            assertArrayEquals(mytomb1, mytomb2);
        }
    }
}