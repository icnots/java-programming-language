package data.structure.peculiar;

import java.util.ArrayList;
import java.util.HashSet;

public class StuffyList<E> extends ArrayList<E>{
    private E neededElement;

    public StuffyList(E neededElement){
        super();

        this.neededElement = neededElement;
    }

    public boolean add(HashSet<E> elems){
        if (elems.contains(neededElement)){
            return addAll(elems);
        }else{
            HashSet<E> newElems = new HashSet<>(elems);
            newElems.add(neededElement);

            return addAll(newElems);
        }
    }

    @Override
    public boolean add(E elem){
        HashSet<E> elems = new HashSet<>();
        elems.add(elem);
        if (!elems.contains(neededElement)){
            elems.add(neededElement);
        }

        return addAll(elems);
    }
}