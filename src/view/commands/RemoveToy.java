package view.commands;

import view.ConsoleUI;

public class RemoveToy extends Command{
    public RemoveToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить игрушку из розыгрыша";
    }

    @Override
    public void execute() {
        consoleUI.removeToy();
    }
}
