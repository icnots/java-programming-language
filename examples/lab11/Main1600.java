import java.util.List;
import java.util.LinkedList;
import java.util.Objects;

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
        List<Animal> animals = new LinkedList<>();

        animals.add(new Dog());
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(0, new Cat());

        for (Animal animal : animals){
            animal.step();
            animal.shout();
        }
    }
}