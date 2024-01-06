package model;

import model.toyListBuilder.ToyListBuilder;
import model.toysItems.Toy;
import model.toysItems.ToyToGive;
import model.toysItems.ToysGiven;
import model.toysItems.ToysList;
import model.writer.MyException;
import model.writer.Writable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Handler {
    public int quantity;
    private ToysList<Toy> toysList;
    private ToyToGive<Toy> toysToGive;
    public ToysGiven<Toy> toysGiven;
    private ToyListBuilder builder;
    Writable writable;
    String fileToysGiven = "src/model/writer/toysGiven.txt";
    String fileToysQueue = "src/model/writer/toysQueue.txt";

    public Handler(int quantity){
        this.quantity = quantity;
        toysList = new ToysList();
        toysToGive = new ToyToGive();
        builder = new ToyListBuilder();
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    public void saveToyGiven(Toy prize){
        File file = new File(fileToysGiven);
        ToysGiven list = new ToysGiven();
        if(file.exists()){
            try {
                loadToysGiven();
                list = loadToysGiven();
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        list.addToy(prize);
        try {
            writable.save(list, fileToysGiven);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
    public ToysGiven loadToysGiven() throws MyException {
        toysGiven = new ToysGiven();
        try {
            toysGiven = (ToysGiven) writable.read(fileToysGiven);
        } catch (FileNotFoundException e) {
            throw new MyException("Файл не найден");
        } catch (MyException e){
            System.out.println(e.getMessage());
        }
        return toysGiven;
    }
    public void saveToysToGive(ToyToGive toysToGive){
        try {
            writable.save(toysToGive, fileToysQueue);
        } catch (MyException e) {
            System.out.println(e.getMessage());;
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
    public String printQueue(){
        return toysToGive.getInfo();
    }
    public String printToysGiven(){
        return toysGiven.getInfo();
    }
    public String printToy(int id){
        return toysList.getToyInfo(id);
    }
    public String printToyName(int id){
        return toysList.getToyName(id);
    }
    public void createQueue(int quantity){
        prizeDraw(quantity);
        saveToysToGive(toysToGive);
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
            toysToGive.addToy(toysList.findToy(id));
        }
    }
    public boolean findById(int id){
        return toysList.findToy(id) != null;
    }
    public void generateToyList(){
        toysList = builder.generateToyList();
    }
    public int getPrize(){
        Toy prize;
        if(toysToGive.size()>0){
            prize = (Toy) toysToGive.removeToy(0);
            saveToyGiven(prize);
            return prize.getToyId();
        }
        return -1;
    }
}