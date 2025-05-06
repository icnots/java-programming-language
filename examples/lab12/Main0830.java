import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Iterator;

class ZooIterator implements Iterator<Animal>{
    private List<Animal> l;
    private int counter;
    private int length;
    ZooIterator(List<Animal> list){
        l = new ArrayList<>(list);
        counter = 0;
        length = l.size();
    }
    @Override public boolean hasNext(){
        return counter < length;
    }
    @Override public Animal next(){
        return l.get(counter++);
    }
}

class Zoo implements Iterable<Animal>{
    private List<Animal> innerData = new LinkedList<>();

    @Override public Iterator<Animal> iterator(){
        return new ZooIterator(innerData);
    }
    public void add(Animal a){
        innerData.add(a);
    }
}


interface Animal{
    public default void shout(){
        System.out.println(" is shouting.");
    }
    public abstract void step();
}

class Dog implements Animal{

    @Override
    public void shout(){
        System.out.print("Dog");
        Animal.super.shout();
    }

    @Override
    public void step(){
        System.out.println("Step is made by a dog.");
    }
}

final class Cat implements Animal, Comparable<Cat>{
    @Override
    public void shout(){
        System.out.print("Cat");
        Animal.super.shout();
    }

    @Override
    public void step(){
        System.out.println("Step is made by a cat.");
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Cat c){
            c.shout();
            return true;
        }

        if (obj.getClass() == this.getClass()){
            Cat c = (Cat)obj;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(/*lists, members, fklfsddfsjkfsd, sdf, fsd*/);
    }

    @Override
    public int compareTo(Cat c){
        /*" this < c "
        return -1 vagy negatív
        " this == c "
        return 0
        " this > c "
        return +1 vagy pozitív*/
        return 0;
    }
}


public class Main0830{
    public static void main(String[] args){
        Zoo zoo = new Zoo();

        zoo.add(new Dog());
        zoo.add(new Dog());
        zoo.add(new Cat());
        zoo.add(new Cat());

        Iterator<Animal> it = zoo.iterator();
        while (it.hasNext()){
            Animal animal = it.next();
            // belseje
        }

        for (Animal animal : zoo){
            // belseje
            animal.shout();
            animal.step();
        }
    }
}
