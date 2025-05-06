import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Iterator;

class ZooIterator implements Iterator<Animal>{
    private List<Animal> innerData;
    private int counter;

    ZooIterator(List<Animal> list){
        innerData = new ArrayList<Animal>(list);
        counter = 0;
    }

    @Override
    public boolean hasNext()
    {
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
    public default void shout(){
        System.out.println("is shouting.");
    }
    public abstract void step();
}

class Dog extends Object implements Animal{
    @Override
    public void shout(){
        System.out.print("Dog ");
        Animal.super.shout();
    }

    @Override
    public void step(){
        System.out.println("A step is made by a dog.");
    }
}

class Cat implements Animal, Comparable<Cat>{
    @Override
    public void shout(){
        System.out.print("Cat ");
        Animal.super.shout();
    }

    @Override
    public void step(){
        System.out.println("A step is made by a cat.");
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (this.hashCode() != obj.hashCode()){
            return false;
        }

        if (obj.getClass().equals(this.getClass())){
            return true;
        }
        
        if (obj instanceof Cat c){
            //Cat c = (Cat)obj;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(/*field1, field2*/);
        //return 1;
    }

    @Override
    public int compareTo(Cat that){
        /* this < that */
        //return -1; // negative
        /* this == that */
        return 0;
        /* this > that */
        //return 1; // positive;
    }

    //public/protected/private/0 final/0 static/0 abstract/0/default returnType methodName(ParamType1 param1, ParamType2 param2) throws FancyException {}/;
}



public class Main1400{
    public static void main(String[] args){
        Zoo zoo = new Zoo();

        zoo.add(new Dog());
        zoo.add(new Dog());
        zoo.add(new Cat());
        zoo.add(new Cat());

        for (Animal animal : zoo){
            animal.step();
            animal.shout();
            System.out.println();
        }

        double d1 = 1.0, d2 = 0.9;

        if (Double.valueOf(d1).equals(d2)){}
    }
}
