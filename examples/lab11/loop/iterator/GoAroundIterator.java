package loop.iterator;

import java.util.Iterator;
import java.util.List;

public final class GoAroundIterator<T> implements Iterator<T> {
    private int idx = 0;
    private int round = 0;

    private int roundCount;
    private List<T> elements;
    
    public GoAroundIterator(int roundCount, List<T> elements) {
        this.roundCount = roundCount;
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return round < roundCount;
    }

    @Override
    public T next() {
        T retval = elements.get(idx);
        idx = (idx+1) % elements.size();
        if (idx == 0)    ++round;

        return retval;
    }
}