package view.commands;

import view.ConsoleUI;

public class AddToy extends Command{
    public AddToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить игрушку в розыгрыш";
    }

    @Override
    public void execute() {
        consoleUI.addToy();
    }
}
