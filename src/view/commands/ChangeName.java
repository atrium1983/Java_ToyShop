package view.commands;

import view.ConsoleUI;

public class ChangeName extends Command{
    public ChangeName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить название игрушки";
    }

    @Override
    public void execute() {
        consoleUI.changeName();
    }
}
