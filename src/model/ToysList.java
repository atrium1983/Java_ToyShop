package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ToysList implements Serializable {
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
        info.append("Наименование игрушек, участвующих в розыгрыше. Всего => ");
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

    @Override
    public String toString(){
        return getInfo();
    }

    public ArrayList<String> prizeDraw(int quantity){
        ArrayList<String> toysToGive = new ArrayList<>();
        for (Toy toy : toysList) {
            String name = toy.getToyName();
            int frequency = toy.getFrequency();
            toysToGive.addAll(getSimpleList(name, frequency, quantity));
            Collections.shuffle(toysToGive);
        }
        return toysToGive;
    }

    public ArrayList<String> getSimpleList(String name, int frequency, int quantity){
        int length = (frequency*quantity/100);
        ArrayList<String> nameArray = new ArrayList<>();
        for (int i = 0; i<length; i++){
            nameArray.add(name);
        }
        return nameArray;
    }
}
