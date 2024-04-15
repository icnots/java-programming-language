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
        /// Get the multiplicity if it was present, 0 otherwise
        /// and increment it
        int multiplicity = getCount(elem) + 1;

        elemToCount.put(elem, Integer.valueOf(multiplicity));
        
        return multiplicity;
    }

    public int getCount(E elem){
        Integer multiplicityInteger = elemToCount.get(elem);
        int multiplicity;
        if (null == multiplicityInteger){
            multiplicity = 0;
        }else{
            multiplicity = multiplicityInteger.intValue();
        }
        return multiplicity;

        /*
        // or equivalently:
        return elemToCount.getOrDefault(elem, 0).intValue();
        */
    }

    public MultiSet<E> intersect(MultiSet<E> that){
        MultiSet<E> intersection = new MultiSet<>();

        for (E elem : elemToCount.keySet()){
            int multiplicity = Math.min(this.getCount(elem), that.getCount(elem));

            for (int i = 0; i < multiplicity; i++){
                intersection.add(elem);
            }

            /*
            // or equvalently (private members are available for the class):
            if (multiplicity > 0){
                intersection.elemToCount.put(elem, Integer.valueOf(multiplicity));
            }
            */
        }

        return intersection;
    }

    public int size(){
        int n = 0;
        for (E elem : elemToCount.keySet()){
            n += getCount(elem);
        }
        return n;
    }

    public int countExcept(E focused){
        int n = 0;
        for (E elem : elemToCount.keySet()){
            if (!elem.equals(focused)){
                n += getCount(elem);
            }
        }
        return n;

        /*
        // or equivalently
        return size()-getCount(focused);
        */
    }
}