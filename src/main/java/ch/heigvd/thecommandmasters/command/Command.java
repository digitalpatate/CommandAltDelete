package ch.heigvd.thecommandmasters.command;

/**
 * Represents a command with a priority that can be executed and undone.
 */
public abstract class Command {

    public final int PRIORITY;
    public final int COST;

    public String name = null;
    public String description = null;

    /**
     * Constructor.
     * @param priority command's priority
     * @param cost the command's cost
     */
    public Command(int priority, int cost) {
        this.PRIORITY = priority;
        this.COST = cost;
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
