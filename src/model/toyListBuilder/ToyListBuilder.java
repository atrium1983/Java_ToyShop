package model.toyListBuilder;

import model.toysItems.Toy;
import model.toysItems.ToysList;

public class ToyListBuilder {
    private int currentId = 0;

    public Toy buildList(String name, int frequency){
        Toy toy = new Toy(currentId++, name, frequency);
        return toy;
    }

    public ToysList generateToyList() {
        ToysList toysList = new ToysList();
        Toy dole = new Toy(currentId++, "Кукла", 10);
        toysList.addToy(dole);
        Toy constructor = new Toy(currentId++, "Конструктор", 20);
        toysList.addToy(constructor);
        Toy robot = new Toy(currentId++, "Робот", 30);
        toysList.addToy(robot);
        Toy bear = new Toy(currentId++, "Медвежонок", 10);
        toysList.addToy(bear);
        Toy car = new Toy(currentId++, "Машинка", 30);
        toysList.addToy(car);

        return toysList;
    }
}
