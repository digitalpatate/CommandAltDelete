package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.Command;

/**
 * Represents a command that uses en entity to execute or undo itself.
 */
public abstract class Action extends Command {

    private Entity entity;

    /**
     * Constructor.
     * @param entity action's entity.
     */
    public Action(Entity entity) {
        this(0, entity);
    }

    /**
     * Constructor.
     * @param priority command's priority.
     * @param entity actions entity.
     */
    public Action(int priority, Entity entity) {
        super(priority);
        this.entity = entity;
    }

    /**
     * Gets the action's entity.
     * @return entity.
     */
    public Entity getEntity() {
        return entity;
    }
}
