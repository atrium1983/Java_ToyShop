package model;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<Toy> implements Iterator<Toy> {

    public int index;
    public List<Toy> toyList;
    public ToyIterator(List<Toy> toyList) {
        this.toyList = toyList;
    }

    @Override
    public boolean hasNext() {
        return index < toyList.size();
    }

    @Override
    public Toy next() {
        return toyList.get(index);
    }

//    @Override
//    public void remove() {
//        Iterator.super.remove();
//    }
}
