package model.toysItems;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<E extends LotteryItem> implements Iterator<E> {

    public int index;
    public List<E> toyList;
    public ToyIterator(List<E> toyList) {
        this.toyList = toyList;
    }

    @Override
    public boolean hasNext() {
        return index < toyList.size();
    }

    @Override
    public E next() {
        return toyList.get(index++);
    }
}
