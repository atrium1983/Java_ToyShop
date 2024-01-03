package model;

import model.toyListBuilder.ToyListBuilder;
import model.writer.Writable;

import java.util.ArrayList;

public class Handler {
    public int quantity;
    private ToysList toysList;
    private ArrayList<String> toysToGive;
    private ToyListBuilder builder;
    Writable writable;
    String filePathToys = "src/model/writer/toysList.txt";
    String filePathLottery = "src/model/writer/toysLottery.txt";

    public Handler(int quantity){
        this.quantity = quantity;
        toysList = new ToysList();
        builder = new ToyListBuilder();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean saveToysList(){
        return writable.save(toysList, filePathToys);
    }

    public void loadToysList(){
        toysList = (ToysList) writable.read(filePathToys);
    }

    public boolean saveToysLottery(ArrayList<String> toysToGive){
        return writable.save(toysToGive, filePathLottery);
    }

    public void loadToysLottery(){
        toysToGive = (ArrayList<String>) writable.read(filePathLottery);
    }

    public void addToy(String toyName, int frequency){
        Toy toy = builder.buildList(toyName, frequency);
        toysList.addToy(toy);
    }

    public void changeFrequency(int id, int frequency){
        toysList.changeFrequency(id, frequency);
    }

    public boolean removeToy(int id){
        return toysList.removeToy(id);
    }
    public void cleanList() {
        toysList.cleanList();
    }
    public String printList(){
        return toysList.getInfo();
    }
    public String printToy(int id){
        return toysList.getToyInfo(id);
    }
    public String printToyToGive(){
        if(prizeDraw()){
            saveToysLottery(toysToGive);
        }
        return toysToGive.toString();
    }
    public boolean findById(int id){
        return toysList.findToy(id) != null;
    }
    public void generateToyList(){
        toysList = builder.generateToyList();
    }

    public boolean prizeDraw(){
        toysToGive = toysList.prizeDraw();
        if(saveToysLottery(toysToGive)){
            return true;
        } else {
            return false;
        }
    }
}
