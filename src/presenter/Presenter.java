package presenter;

import model.Handler;
import model.writer.Writable;
import view.ConsoleUI;

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

    public String printToysGiven(){
        String toysGiven = handler.loadToysGiven();
        return toysGiven;
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
        consoleUI.answer(handler.createQueue(quantity));
    }

    public boolean findById(int id){
        return handler.findById(id);
    }

    public void setWritable(Writable writable){
        handler.setWritable(writable);
    }

    public void getPrize(){
        String prize = handler.getPrize();
        if(prize != null){
            System.out.println(prize);
            handler.saveToyGiven(prize);
        } else {
            consoleUI.answer("Очередь для розыгрыша игрушек пуста");
        }
    }
}
