package model.toysItems;

import java.io.Serializable;
import java.util.*;

public class ToysList implements Serializable, Iterable<Toy> {
    ArrayList<Toy> toysList;

    public ToysList(){
        toysList = new ArrayList<>();
    }

    public void addToy(Toy toy){
        toysList.add(toy);
    }
    public Toy findToy(int id){
        for (Toy toy : toysList) {
            if(toy.getToyId() == id){
                return toy;
            }
        }
    return null;
    }

    public void cleanList(){
        toysList.clear();
    }

    public boolean removeToy(int id){
        Toy toy = findToy(id);
        return toysList.remove(toy);
    }

    public void changeFrequency(int id, int frequency){
        for (Toy toy : toysList) {
            if (toy.getToyId() == id) {
                toy.setFrequency(frequency);
            }
        }
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Список игрушек. Всего => ");
        info.append((toysList.size()));
        info.append(" \n");
        for (Toy toy: toysList) {
            info.append(toy);
            info.append("\n");
        }
        return info.toString();
    }

    public String getToyInfo(int id){
        StringBuilder info = new StringBuilder();
        info.append(toysList.get(id));
        info.append("\n");
        return info.toString();
    }
    public String getToyName(int id){
        StringBuilder info = new StringBuilder();
        info.append(toysList.get(id).getToyName());
        info.append("\n");
        return info.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyIterator<>(toysList);
    }
}
