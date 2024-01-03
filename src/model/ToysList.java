package model;

import java.io.Serializable;
import java.util.ArrayList;

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
    public void changeName(int id, String name){
        for (int i = 0; i < toysList.size(); i++) {
            if(toysList.get(i).getToyId() == id){
                toysList.get(i).setToyName(name);
            }
        }
    }
    public void changeFrequency(int id, int frequency){
        for (int i = 0; i < toysList.size(); i++) {
            if(toysList.get(i).getToyId() == id){
                toysList.get(i).setFrequency(frequency);
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

    public ArrayList<String> prizeDraw(){
        int quantity = 20;
        ArrayList<String> toysToGive = new ArrayList<>();
        for (int i = 0; i < toysList.size(); i++) {
            String name = toysList.get(i).getToyName();
            int frequency = toysList.get(i).getFrequency();
            toysToGive.addAll(getSimpleList(name, frequency, quantity));
        }
        return toysToGive;
    }

    public ArrayList<String> getSimpleList(String name, int frequency, int quantity){
        int length = (frequency*quantity/100);
        System.out.println(length);
        ArrayList<String> nameArray = new ArrayList<>();
        for (int i = 0; i<length; i++){
            nameArray.add(name);
        }
        return nameArray;
    }
}
