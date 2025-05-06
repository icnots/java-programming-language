import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Iterator;

class ZooIterator implements Iterator<Animal>{
    private List<Animal> list;
    private int counter;
    private int length;

    ZooIterator(List<Animal> list){
        this.list = new ArrayList<>(list);
        counter = 0;
        length = list.size();
    }

    @Override
    public boolean hasNext(){
        return counter < length;
    }
    @Override
    public Animal next(){
        return list.get(counter++);
    }
}

class Zoo implements Iterable<Animal>{
    private List<Animal> innerData = new LinkedList<>();

    @Override
    public Iterator<Animal> iterator(){
        return new ZooIterator(innerData);
    }

    public void add(Animal animal){
        innerData.add(animal);
    }
}

interface Animal{
    public abstract void shout();
    public default void step(){
        System.out.print("Step made by a ");
    }
}

class Dog implements Animal{
    @Override
    public void shout(){
        System.out.println("Dog is shouting.");
    }
    @Override
    public void step(){
        Animal.super.step();
        System.out.println("dog.");
    }
}


class Cat extends Object implements Animal, Comparable<Cat>{
    @Override
    public void shout(){
        System.out.println("Cat is shouting.");
    }
    @Override
    public void step(){
        Animal.super.step();
        System.out.println("cat.");
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (this.hashCode() != obj.hashCode()){
            return false;
        }

        if (this.getClass() == (obj.getClass())){
            Cat c = (Cat) obj;
        }
        if (obj instanceof Cat){
            Cat c = (Cat) obj;
            
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(/*field1, field2, otherFiled */);
        //return 1;
    }
    
    @Override
    public int compareTo(Cat that){
        /* this > that */
        //return 1; // poositive
        /* this == that */
        return 0;
        /* this < that */
        //return -1; // negative
    }
}

public class Main1015{
    public static void main(String[] args){
        Zoo zoo = new Zoo();
        
        zoo.add(new Dog());
        zoo.add(new Dog());
        zoo.add(new Cat());
        zoo.add(new Cat());
        
        Cat c = new Cat();
        Dog d = new Dog();
        System.out.println(c.equals(c));
        
        for (Animal animal : zoo){
            animal.step();
            animal.shout();
        }
    }
}
