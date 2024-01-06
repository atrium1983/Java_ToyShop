package presenter;

import model.Handler;
import model.writer.MyException;
import model.writer.Writable;
import view.ConsoleUI;

public class Presenter {
    private final Handler handler;
    private final ConsoleUI consoleUI;

    public Presenter (ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
        handler = new Handler(10);
    }

    public void printToysGiven(){
        try {
            handler.loadToysGiven();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        consoleUI.answer(handler.printToysGiven());
    }
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
        handler.createQueue(quantity);
        consoleUI.answer(handler.printQueue());
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
