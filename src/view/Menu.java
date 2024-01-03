package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;
    public Menu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new AddToy(consoleUI));
        commandList.add(new ChangeFrequency(consoleUI));
        commandList.add(new RemoveToy(consoleUI));
        commandList.add(new CleanList(consoleUI));
        commandList.add(new PrintToyList(consoleUI));
        commandList.add(new CreateQueue(consoleUI));
        commandList.add((new MakeLottery(consoleUI)));
        commandList.add(new PrintToysGiven(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String getMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите действие :\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
