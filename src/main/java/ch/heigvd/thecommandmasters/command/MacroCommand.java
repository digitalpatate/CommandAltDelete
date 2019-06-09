package ch.heigvd.thecommandmasters.command;

import java.util.List;

/**
 * Represents a composite of commands. Executing or undoing a macro command is applied to all children.
 */
public class MacroCommand extends Command {

    private List<Command> commands;

    /**
     * Constructor with priority and cost to zero.
     * @param commands list of sub-commands.
     */
    public MacroCommand(List<Command> commands) {
        this(0, 0, commands);
    }

    /**
     * Constructor
     * @param priority command's priority.
     * @param cost the command's cost
     * @param commands list of sub-commands.
     */
    public MacroCommand(int priority, int cost, List<Command> commands) {
        super(priority, cost);
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }

    @Override
    public void undo() {
        commands.forEach(Command::undo);
    }

    /**
     * Adds a command if it's not already a child.
     * @param command action to add.
     */
    public void addCommand(Command command) {

        if (command != this && !hasChild(command)) {
            commands.add(command);
        }
    }

    /**
     * Check if a command is a child.
     * @param command command to check.
     * @return true if it is a child.
     */
    private boolean hasChild(Command command) {

        for (Command c : commands) {
            if (c == command ||
                    (c instanceof MacroCommand && ((MacroCommand) c).hasChild(command))) {

                return true;
            }
        }

        return false;
    }
}
