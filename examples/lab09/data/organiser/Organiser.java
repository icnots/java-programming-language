package data.organiser;

import java.util.ArrayList;
import java.util.Map;

public class Organiser<T>{
    private ArrayList<T> elems;
    private ArrayList<Map.Entry<Integer, Integer>> swaps;

    @SafeVarargs
    public Organiser(T... elems){
        this.elems = new ArrayList<>();
        for (T elem : elems){
            this.elems.add(elem);
        }

        swaps = new ArrayList<>();
    }

    public void addSwap(int fst, int snd){
        swaps.add(Map.entry(fst, snd));
    }

    public ArrayList<T> get(){
        return new ArrayList<T>(elems);
    }

    public T get(int index){
        return elems.get(index);
    }

    private void swap(int fst, int snd){
        T temp = elems.get(fst);
        elems.set(fst, elems.get(snd));
        elems.set(snd, temp);
    }

    public void runSwaps(){
        for (Map.Entry<Integer, Integer> swap : swaps){
            swap(swap.getKey(), swap.getValue());
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T elem : elems){
            sb.append(elem);
            sb.append(' ');
        }
        sb.append("]");

        return sb.toString();
    }
}