package view.commands;

import view.ConsoleUI;

public class MakeLottery extends Command{
    public MakeLottery(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Провести розыгрыш игрушки (выдать игрушку)";
    }

    @Override
    public void execute() {
        consoleUI.getPrize();
    }
}
