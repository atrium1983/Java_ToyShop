package view.commands;

import view.ConsoleUI;

public class ChangeFrequency extends Command {
    public ChangeFrequency(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить частоту выпадения игрушки в розыгрыше";
    }

    @Override
    public void execute() {
        consoleUI.changeFrequency();
    }
}
