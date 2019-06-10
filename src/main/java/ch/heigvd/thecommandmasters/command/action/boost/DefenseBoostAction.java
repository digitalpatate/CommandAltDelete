package ch.heigvd.thecommandmasters.command.action.boost;

import ch.heigvd.thecommandmasters.Character.Entity;

public class DefenseBoostAction extends BoostAction {

    public DefenseBoostAction(Entity entity, int value, int duration) {
        super(entity, value, duration);
    }

    public DefenseBoostAction(int priority, int cost, Entity entity, int value, int duration) {
        super(priority, cost, entity, value, duration);
    }

    @Override
    public void execute() {
        createBoost();
        entity.addDefenseBoost(boost);
    }

    @Override
    public void undo() {
        entity.removeDefenseBoost(boost);
    }
}
