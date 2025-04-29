import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
        List<Animal> animals = new LinkedList<>();

        animals.add(new Dog());
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(0, new Cat());

        for (Animal animal : animals){
            animal.shout();
            animal.step();
        }
    }
}
