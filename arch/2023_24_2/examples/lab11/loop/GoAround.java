package loop;

import java.util.ArrayList;
import java.util.List;
import loop.iterator.GoAroundIterator;

public class GoAround<T> implements Iterable<T>{
    private int roundCount;
    private List<T> elements;

    @SafeVarargs
    public GoAround(int roundCount, T...elements){
        this.roundCount = roundCount;
        this.elements = new ArrayList<>(elements.length);
        for (T elem : elements){
            this.elements.add(elem);
        }
    }

    @Override
    public GoAroundIterator<T> iterator(){
        return new GoAroundIterator<>(roundCount, elements);
    }
}