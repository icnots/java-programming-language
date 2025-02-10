package data.structure;

import java.util.LinkedList;
import java.util.ArrayList;

public class RangedStack<E>{
    private LinkedList<E> elems;

    public RangedStack(){
        elems = new LinkedList<>();
    }

    public RangedStack(RangedStack<E> that){
        elems = new LinkedList<>(that.elems);
    }

    public ArrayList<E> pop(int n){
        ArrayList<E> res = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (elems.size() > 0){
                E elem = elems.pop();
                res.add(elem);
            }else{
                break;
            }
        }

        return res;
    }

    @SuppressWarnings("unchecked")
    public void push(E... elems) {
        for (E elem : elems) {
            this.elems.push(elem);
        }
    }
}