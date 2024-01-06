package model.toysItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ToyToGive<E extends LotteryItem> implements Serializable, Iterable<E> {
    ArrayList<E> toysToGive;

    public ToyToGive(){
        toysToGive = new ArrayList<>();
    }

    public void addToy(E toy){
        toysToGive.add(toy);
    }
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Очередь игрушек для выдачи. Всего => ");
        info.append((toysToGive.size()));
        info.append(" \n");
        for (E toy: toysToGive) {
            info.append(toy);
            info.append("\n");
        }
        return info.toString();
    }
    public int size(){
        return toysToGive.size();
    }
    public E removeToy (int id){
        return toysToGive.remove(id);
    }
    @Override
    public String toString(){
        return getInfo();
    }
    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(toysToGive);
    }
}
