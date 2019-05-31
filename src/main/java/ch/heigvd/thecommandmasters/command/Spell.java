package ch.heigvd.thecommandmasters.command;

import ch.heigvd.thecommandmasters.Character.Entity;

import java.util.List;

public abstract class Spell extends Action {

    private List<Action> actions;

    protected Spell(Entity entity, int priority, List<Action> actions) {
        super(entity, priority);
        this.actions = actions;
    }

    @Override
    public void execute() {
        for (Action action: actions) {
            action.execute();
        }
    }

    @Override
    public void undo() {
        for (Action action: actions) {
            action.undo();
        }
    }
}
