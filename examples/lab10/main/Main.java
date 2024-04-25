package main;

import java.util.ArrayList;
import living.Creature;
import living.animal.Dog;
import living.animal.Cat;


public class Main{
    public static void printVoices(ArrayList<Creature> animals){
        for (Creature c : animals){
            if (c instanceof Dog){
                Dog dog = (Dog)c;
                dog.bark();
            }else if(c instanceof Cat){
                Cat cat = (Cat)c;
                cat.meow();
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Creature> animals = new ArrayList<>();

        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog(1));
        animals.add(new Cat(1));

        printVoices(animals);

        ArrayList<Creature> newList = new ArrayList<>();
        for (Creature c : animals){
            newList.addAll(c.reproduce());
        }
        animals = newList;

        System.out.println("After reproduce:");
        printVoices(animals);

        newList = new ArrayList<>();
        for (Creature c : animals){
            newList.addAll(c.reproduce());
        }
        animals = newList;

        System.out.println("After reproduce:");
        printVoices(animals);
    }
}