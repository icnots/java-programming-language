package data.structure;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class MultiSet<E>{
    private HashMap<E, Integer> elemToCount;

    @SafeVarargs
    public MultiSet(E... elems){
        elemToCount = new HashMap<>();

        for (E elem : elems){
            add(elem);
        }
    }

    public int add(E elem){
        int newCount = elemToCount.getOrDefault(elem, 0) + 1;
        elemToCount.put(elem, newCount);
        return newCount;
    }

    public int getCount(E elem){
        return elemToCount.getOrDefault(elem, 0);
    }

    public MultiSet<E> intersect(MultiSet<E> that){
        MultiSet<E> intersection = new MultiSet<>();

        for (E elem : elemToCount.keySet()){
            int minCount = Math.min(this.getCount(elem), that.getCount(elem));
            if (minCount > 0){
                intersection.elemToCount.put(elem, minCount);
            }
        }

        return intersection;
    }

    public int countExcept(Set<E> notCounted){
        int sum = 0;

        for (E elem : elemToCount.keySet()){
            if (!notCounted.contains(elem)){
                sum += elemToCount.get(elem);
            }
        }

        return sum;
    }

    public int size(){
        return countExcept(new HashSet<E>());
    }
}