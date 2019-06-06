package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;

public abstract class HealAction extends Action {

    private int amount;

    public HealAction(Entity entity, int amount) {
        super(entity);
        this.amount = amount;
    }

    @Override
    public void execute() {
        getEntity().heal(amount);
    }

    @Override
    public void undo() {
        // TODO: ignore defense!
        getEntity().damage(amount);
    }
}
