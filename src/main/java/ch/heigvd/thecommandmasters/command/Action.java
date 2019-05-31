package ch.heigvd.thecommandmasters.command;

import ch.heigvd.thecommandmasters.Character.Entity;

public abstract class Action implements Command {

    private Entity entity;

    public final int PRIORITY;

    public Action(Entity entity, int priority) {
        this.entity = entity;
        this.PRIORITY = priority;
    }

    public Entity getEntity() {
        return entity;
    }
}
