package model;

import model.toyListBuilder.ToyListBuilder;
import model.writer.Writable;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Handler {
    public int quantity;
    private ToysList toysList;
    private ArrayList<Toy> toysQueue;
    private ToyListBuilder builder;
    Writable writable;
    String fileToysGiven = "src/model/writer/toysGiven.txt";
    String fileToysQueue = "src/model/writer/toysQueue.txt";

    public Handler(int quantity){
        this.quantity = quantity;
        toysList = new ToysList();
        builder = new ToyListBuilder();
        toysQueue = new ArrayList<>();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean saveToyGiven(Toy prize){
        return writable.save(prize, fileToysGiven);
    }

    public ArrayList<Toy> loadToysGiven(){
        try {
            return (ArrayList<Toy>) writable.read(fileToysGiven);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveToysLottery(ArrayList<Toy> toysQueue){
        return writable.save(toysQueue, fileToysQueue);
    }

//    public void loadToysLottery() {
//        try {
//            toysQueue = (ArrayList<Toy>) writable.read(fileToysQueue);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

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
    public String printToyName(int id){
        return toysList.getToyName(id);
    }
    public ArrayList<Toy> createQueue(int quantity){
        toysQueue = toysList.prizeDraw(quantity);
        saveToysLottery(toysQueue);
        return toysQueue;
    }

    public boolean findById(int id){
        return toysList.findToy(id) != null;
    }
    public void generateToyList(){
        toysList = builder.generateToyList();
    }

    public int getPrize(){
        Toy prize;
        if(toysQueue.size()>0){
            prize = toysQueue.remove(0);
            saveToyGiven(prize);
            return prize.getToyId();
        }
        return -1;
    }
}
