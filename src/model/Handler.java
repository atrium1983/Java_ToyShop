package model;

import model.toyListBuilder.ToyListBuilder;
import model.writer.Writable;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Handler {
    public int quantity;
    private ToysList toysList;
    private PriorityQueue<String> toysQueue;
    private ToyListBuilder builder;
    Writable writable;
    String fileToysGiven = "src/model/writer/toysGiven.txt";
    String fileToysQueue = "src/model/writer/toysQueue.txt";

    public Handler(int quantity){
        this.quantity = quantity;
        toysList = new ToysList();
        builder = new ToyListBuilder();
        toysQueue = new PriorityQueue<>();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean saveToyGiven(String prize){
        return writable.save(prize, fileToysGiven);
    }

    public String loadToysGiven(){
        try {
            String toysGiven = (String) writable.read(fileToysGiven);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            return (String) writable.read(fileToysGiven);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveToysLottery(PriorityQueue<String> toysQueue){
        return writable.save(toysQueue, fileToysQueue);
    }

    public void loadToysLottery() {
        try {
            toysQueue = (PriorityQueue<String>) writable.read(fileToysQueue);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
    public String createQueue(int quantity){
        ArrayList<String> list = toysList.prizeDraw(quantity);
        toysQueue.addAll(list);
        saveToysLottery(toysQueue);
        return toysQueue.toString();
    }
    public boolean findById(int id){
        return toysList.findToy(id) != null;
    }
    public void generateToyList(){
        toysList = builder.generateToyList();
    }

    public String getPrize(){
        String prize;
        prize = toysQueue.poll();
        return prize;
    }
}
