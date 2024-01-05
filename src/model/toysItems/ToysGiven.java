package model.toysItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ToysGiven implements Serializable, Iterable<Toy> {
    ArrayList<Toy> toysGiven;

    public ToysGiven(){
        toysGiven = new ArrayList<>();
    }
    public void addToy(Toy toy){
        toysGiven.add(toy);
    }
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Список разыгранных игрушек. Всего => ");
        info.append((toysGiven.size()));
        info.append(" \n");
        for (Toy toy: toysGiven) {
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
    public Iterator<Toy> iterator() {
        return new ToyIterator<>(toysGiven);
    }
}
