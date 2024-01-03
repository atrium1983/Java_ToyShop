package view.commands;

import view.ConsoleUI;

public class ToysLottery extends Command{
    public ToysLottery(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать очередь игрушек для выдачи";
    }

    @Override
    public void execute() {
        consoleUI.printToyToGive();
    }
}
