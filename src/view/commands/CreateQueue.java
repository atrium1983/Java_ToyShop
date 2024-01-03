package view.commands;

import view.ConsoleUI;

public class CreateQueue extends Command{
    public CreateQueue(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать очередь игрушек для розыгрыша";
    }

    @Override
    public void execute() {
        consoleUI.createQueue();
    }
}
