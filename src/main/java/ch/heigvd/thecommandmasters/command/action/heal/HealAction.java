package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.action.Action;

public class HealAction extends Action {

    protected final int value;

    public HealAction(Entity entity, int value) {
        super(entity);
        this.value = value;
    }

    @Override
    final public void execute() {
        entity.heal(value);
    }

    @Override
    final public void undo() {
        entity.damage(value);
    }

    protected int calculateHeal() {
        return value;
    }
}
