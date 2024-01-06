package model.toysItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ToysGiven<E extends LotteryItem> implements Serializable, Iterable<E> {
    ArrayList<E> toysGiven;

    public ToysGiven(){
        toysGiven = new ArrayList<>();
    }
    public void addToy(E toy){
        toysGiven.add(toy);
    }
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Список разыгранных игрушек. Всего => ");
        info.append((toysGiven.size()));
        info.append(" \n");
        for (E toy: toysGiven) {
            info.append(toy.getToyName());
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(toysGiven);
    }
}
