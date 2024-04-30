package loop.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class GoAroundIterator<T> implements Iterator<T>{
    private int idx;
    private int round;
    private int roundCount;
    private List<T> elements;

    public GoAroundIterator(int roundCount, List<T> elements){
        this.idx = 0;
        this.round = 0;
        this.roundCount = roundCount;
        this.elements = new ArrayList<>(elements);
    }

    @Override
    public boolean hasNext(){
        return round < roundCount;
    }

    @Override
    public T next(){
        T value = elements.get(idx);
        idx = (idx+1) % elements.size();
        if (idx == 0){
            round++;
        }
        return value;
    }
}