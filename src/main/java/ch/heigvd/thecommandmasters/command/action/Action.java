package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.Command;

import java.util.logging.Logger;

/**
 * Represents a command that uses en entity to execute or undo itself.
 */
public abstract class Action extends Command {

    protected static final Logger LOG = Logger.getLogger(Command.class.getSimpleName());

    protected final Entity entity;

    /**
     * Constructor with priority and cost to zero.
     * @param entity action's entity.
     */
    public Action(Entity entity) {
        this(0, 0, entity);
    }

    /**
     * Constructor.
     * @param priority command's priority.
     * @param entity actions entity.
     */
    public Action(int priority, int cost, Entity entity) {
        super(priority, cost);
        this.entity = entity;
    }
}
