package view;

import presenter.Presenter;
import java.util.Scanner;
import model.writer.Writable;

public class ConsoleUI {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;
    private String errorId = "Игрушки с таким ID нет в списке";
    public String positive = "Успешно!\n";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }

    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello() {
        answer("Добро пожаловать в меню организации розыгрыша игрушек");
    }

    public void finish() {
        answer("Сеанс завершен. До свидания!");
        work = false;
        scanner.close();
    }

    private void printMenu(){
        answer(menu.getMenu());
    }

    public void printToysList(){
        presenter.print();
    }
    public void createQueue(){
        answer("Введите количество игрушек для розыгрыша :");
        String input = scanner.nextLine();
        int quantity;
        if (checkIfInt(input)) {
            quantity = Integer.parseInt(input);
            presenter.createQueue(quantity);
        } else {
            answer("Попробуйте снова!");
        }
    }

    public void generateToyList(){
        presenter.generateToyList();
    }

    public void addToy(){
        answer("Введите название игрушки : ");
        String name = scanner.nextLine();
        answer("Введите частоту выпадения в процентах");
        String input = scanner.nextLine();
        int frequency;
        if (checkIfInt(input)) {
            frequency = Integer.parseInt(input);
            presenter.addToy(name,frequency);
        } else {
            answer("Попробуйте снова!");
        }

    }

    public void changeFrequency(){
        answer("Введите ID игрушки");
        int id = checkId(scanner.nextLine());
        answer("Введите частоту выпадения игрушки в розыгрыше (в %, например 20%");
        String input = scanner.nextLine();
        int frequency;
        if (checkIfInt(input)) {
            frequency = Integer.parseInt(input);
            presenter.changeFrequency(id, frequency);
            answer(positive);
            presenter.printById(id);
        }
    }

    public void removeToy(){
        answer("Введите ID игрушки");
        int id = checkId(scanner.nextLine());
        if(presenter.removeToy(id)){
            answer(positive);
        }
    }

    public void cleanList() {
        presenter.cleanList();
    }

    private void execute(){
        String input = scanner.nextLine();
        if (checkIfInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkIfInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private int checkId(String id){
        if (checkIfInt(id)) {
            int intId = Integer.parseInt(id);
            if (findById(intId)) {
                return intId;
            }
        }
        return -1;
    }

    private boolean findById(int id){
        return presenter.findById(id);
    }

    private void inputError(){
        answer("Вы ввели некорректное значение. Введите целое число");
    }

    public void printToysGiven(){
        presenter.printToysGiven();
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }

    public void answer(String text) {
        System.out.println(text);
    }

    public void getPrize(){
        presenter.getPrize();
    }
}
