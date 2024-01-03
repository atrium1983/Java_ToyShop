package view.commands;

import view.ConsoleUI;

public class PrintToysGiven extends Command{
    public PrintToysGiven(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать список выданных игрушек";
    }

    @Override
    public void execute() {
        consoleUI.printToysGiven();
    }
}
