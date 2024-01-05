package model;

import model.toyListBuilder.ToyListBuilder;
import model.writer.Writable;

import java.io.File;
import java.io.FileNotFoundException;

public class Handler {
    public int quantity;
    private ToysList toysList;
    private ToysList toysToGive;
    public ToysList toysGiven;
    private ToyListBuilder builder;
    Writable writable;
    String fileToysGiven = "src/model/writer/toysGiven.txt";
    String fileToysQueue = "src/model/writer/toysQueue.txt";

    public Handler(int quantity){
        this.quantity = quantity;
        toysList = new ToysList();
        builder = new ToyListBuilder();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public boolean saveToyGiven(Toy prize){
        File file = new File(fileToysGiven);
        ToysList list = new ToysList();
        if(file.exists()){
            loadToysGiven();
            list = loadToysGiven();
        }
        list.addToy(prize);
        return writable.save(list, fileToysGiven);
    }

    public ToysList loadToysGiven(){
        toysGiven = new ToysList();
        try {
            toysGiven = (ToysList) writable.read(fileToysGiven);
            return toysGiven;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveToysLottery(ToysList toysToGive){
        return writable.save(toysToGive, fileToysQueue);
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
    public String printQueue(){
        return toysToGive.getQueueInfo();
    }
    public String printToy(int id){
        return toysList.getToyInfo(id);
    }
    public String printToyName(int id){
        return toysList.getToyName(id);
    }
    public void createQueue(int quantity){
        toysList.prizeDraw(quantity);
        this.toysToGive = new ToysList();
        for (Toy toy: toysList.toysToGive){
            toysToGive.addToyToGive(toy);
        }
        System.out.println(toysToGive.getQueueInfo());
        saveToysLottery(toysToGive);
    }

    public boolean findById(int id){
        return toysList.findToy(id) != null;
    }
    public void generateToyList(){
        toysList = builder.generateToyList();
    }

    public int getPrize(){
        Toy prize;
        if(toysToGive.sizeToysToGive()>0){
            prize = toysToGive.removeToyFromQueue(0);
            saveToyGiven(prize);
            return prize.getToyId();
        }
        return -1;
    }
}
