package presenter;

import model.Handler;
import model.Toy;
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

//    public void saveToyGiven(){
//        if(handler.saveToyGiven()) {
//            consoleUI.answer(consoleUI.positive);
//        }
//    }

    public void printToysGiven(){
        ArrayList<Toy> list = handler.loadToysGiven();
        String toys = null;
        for (Toy toy : list) {
            toys += toy.toyName +" ";
        }
        consoleUI.answer(toys);
    }

//    public void loadToysLottery(){
//        handler.loadToysLottery();
//        consoleUI.answer(consoleUI.positive);
//    }

    public void addToy(String toyName, int frequency){
        handler.addToy(toyName, frequency);
        consoleUI.answer(consoleUI.positive);
        print();
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
    public void createQueue(int quantity){
        ArrayList<Toy> list = handler.createQueue(quantity);
        for (Toy toy: list) {
            consoleUI.answer(toy.toString());
        }
    }

    public boolean findById(int id){
        return handler.findById(id);
    }

    public void setWritable(Writable writable){
        handler.setWritable(writable);
    }

    public void getPrize(){
        int id = handler.getPrize();
        if(id >= 0){
            consoleUI.answer("Выдана игрушка: ");
            consoleUI.answer(handler.printToyName(id));
        } else {
            consoleUI.answer("Очередь для розыгрыша игрушек пуста");
        }
    }
}
