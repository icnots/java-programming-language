import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
        List<Animal> animals = new LinkedList<>();

        animals.add(new Dog());
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(0, new Cat());

        for (Animal animal : animals){
            animal.step();
            animal.shout();
            System.out.println();
        }
    }
}
