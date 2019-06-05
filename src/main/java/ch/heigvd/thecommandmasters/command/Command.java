package ch.heigvd.thecommandmasters.command;

/**
 * Represents a command with a priority that can be executed and undone.
 */
public abstract class Command {

    public final int PRIORITY;

    /**
     * Constructor
     * @param priority command's priority
     */
    public Command(int priority) {
        this.PRIORITY = priority;
    }

    /**
     * Executes the command
     */
    public abstract void execute();

    /**
     * Undoes the command
     */
    public abstract void undo();
}
