package model.toysItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ToyToGive implements Serializable, Iterable<Toy> {
    ArrayList<Toy> toysToGive;

    public ToyToGive(){
        toysToGive = new ArrayList<>();
    }

    public void addToy(Toy toy){
        toysToGive.add(toy);
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Очередь игрушек для выдачи. Всего => ");
        info.append((toysToGive.size()));
        info.append(" \n");
        for (Toy toy: toysToGive) {
            info.append(toy);
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public int size(){
        return toysToGive.size();
    }

    public Toy removeToy (int id){
        return toysToGive.remove(id);
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyIterator<>(toysToGive);
    }
}
