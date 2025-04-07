package data.organiser;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Organiser<T>{
    private ArrayList<T> elems;
    private ArrayList<Map.Entry<Integer, Integer> > swaps;

    @SafeVarargs
    public Organiser(T... elems){
        this.elems = new ArrayList<>(List.of(elems));
        swaps = new ArrayList<>();
    }

    public void addSwap(int from, int to){
        // Ez itt egy static metódushívás, nem konstruktor!
        swaps.add(Map.entry(Integer.valueOf(from), Integer.valueOf(to)));
    }

    public ArrayList<T> get(){
        return new ArrayList<>(elems);
    }

    public T get(int idx){
        return elems.get(idx);
    }

    private void swap(int from, int to){
        T temp = elems.get(from);
        elems.set(from, elems.get(to));
        elems.set(to, temp);
    }

    public void runSwaps(){
        for (Map.Entry<Integer, Integer> pair : swaps){
            swap(pair.getKey(), pair.getValue());
        }

        swaps = new ArrayList<>();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T elem : elems){
            sb.append(elem);
            sb.append(" ");
        }
        sb.append("]");

        return sb.toString();
    }
}