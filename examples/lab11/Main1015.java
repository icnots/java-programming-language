import java.util.List;
import java.util.LinkedList;
import java.util.Objects;

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
        //return -1; // negativeű
    }
}

public class Main1015{
    public static void main(String[] args){
        List<Animal> animals = new LinkedList<>();
        
        animals.add(new Dog());
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(0, new Cat());
        
        Cat c = new Cat();
        Dog d = new Dog();
        System.out.println(c.equals(c));
        
        for (Animal animal : animals){
            animal.step();
            animal.shout();
        }
    }
}
