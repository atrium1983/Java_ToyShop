package view.commands;

import view.ConsoleUI;

public class CleanList extends Command {
    public CleanList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Очистить список игрушек в розыгрыше";
    }

    @Override
    public void execute() {
        consoleUI.cleanList();
    }
}
