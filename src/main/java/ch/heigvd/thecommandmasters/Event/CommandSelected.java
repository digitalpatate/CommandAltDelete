package ch.heigvd.thecommandmasters.Event;

import ch.heigvd.thecommandmasters.command.Command;

public class CommandSelected {

    private Command command;

    public CommandSelected(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

}



