package data.structure;

import java.util.HashMap;

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
        Integer count = elemToCount.get(elem);

        if (null == count){
            elemToCount.put(elem, 1);
            return 1;
        }else{
            elemToCount.put(elem, count+1);
            return count+1;
        }
    }

    public int getCount(E elem){
        Integer count = elemToCount.get(elem);

        if (null == count){
            return 0;
        }else{
            return count;
        }
    }

    public MultiSet<E> intersect(MultiSet<E> otherMultiSet){
        MultiSet<E> intersection = new MultiSet<>();

        for (E elem : elemToCount.keySet()){
            int count = Math.min(
                elemToCount.get(elem),
                otherMultiSet.getCount(elem)
            );

            if (count > 0){
                intersection.elemToCount.put(elem, count);
            }
        }

        return intersection;
    }

    public int size(){
        int sum = 0;
        
        for (E elem : elemToCount.keySet()){
            sum += elemToCount.get(elem);
        }

        return sum;
    }

    public int countExcept(E elemExcept){
        int sum = 0;
        
        for (E elem : elemToCount.keySet()){
            if (elemExcept != elem){
                sum += elemToCount.get(elem);
            }
        }

        return sum;
    }
}