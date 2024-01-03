package presenter;

import model.Handler;
import model.writer.Writable;
import view.ConsoleUI;

import java.util.ArrayList;

public class Presenter {
    private final Handler handler;
    private final ConsoleUI consoleUI;

    public Presenter (ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
        handler = new Handler(10);
    }

    public void saveToysList(){
        if(handler.saveToysList()) {
            consoleUI.answer(consoleUI.positive);
        }
    }

    public void loadToysList(){
        handler.loadToysList();
        consoleUI.answer(consoleUI.positive);
    }

    public void loadToysLottery(){
        handler.loadToysLottery();
        consoleUI.answer(consoleUI.positive);
    }

    public void addToy(String toyName, int frequency){
        handler.addToy(toyName, frequency);
        consoleUI.answer(consoleUI.positive);
        print();
    }

    public void changeName(int id, String name){
        handler.changeName(id, name);
    }
    public void changeFrequency(int id, int frequency){
        handler.changeFrequency(id, frequency);
    }

    public boolean removeToy(int id){
        return handler.removeToy(id);
    }

    public void cleanList() {
        handler.cleanList();
    }
    public void generateToyList(){
        handler.generateToyList();
        print();
    }
    public void print(){
        consoleUI.answer(handler.printList());
    }

    public void printById(int id){
        consoleUI.answer(handler.printToy(id));
    }
    public void printToyToGive(){
//        prizeDraw();
        consoleUI.answer(handler.printToyToGive());
    }

    public boolean findById(int id){
        return handler.findById(id);
    }

    public void setWritable(Writable writable){
        handler.setWritable(writable);
    }
//    public void prizeDraw(){
//        if(handler.prizeDraw()){
//            consoleUI.answer(consoleUI.positive);
//        }
//    }
}
