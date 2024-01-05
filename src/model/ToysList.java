package model;

import java.io.Serializable;
import java.util.*;

public class ToysList implements Serializable, Iterable<Toy> {
    ArrayList<Toy> toysList;
    ArrayList<Toy> toysToGive;

    public ToysList(){
        toysList = new ArrayList<>();
        toysToGive = new ArrayList<>();
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
    public void addToyToGive(Toy toy){
        toysToGive.add(toy);
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

    public String getQueueInfo() {
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

    public void prizeDraw(int quantity) {
        List<Integer> idToysToGive = new ArrayList<>();
        for (Toy toy : toysList) {
            int frequency = toy.getFrequency();
            int length = (frequency * quantity / 100);
            for (int i = 0; i < length; i++) {
                idToysToGive.add(toy.getToyId());
            }
        }
        Collections.shuffle(idToysToGive);
        for (Integer id : idToysToGive) {
            toysToGive.add(findToy(id));
            getToyInfo(id);
        }
    }

    public int sizeToysToGive(){
        return toysToGive.size();
    }
    public Toy removeToyFromQueue(int id){
        return toysToGive.remove(id);
    }

    @Override
    public Iterator<Toy> iterator() {
        return new ToyIterator<>(toysToGive);
    }
}
