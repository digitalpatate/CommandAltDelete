package ch.heigvd.thecommandmasters.command.action.boost;

import ch.heigvd.thecommandmasters.Character.Entity;

public class AttackBoostAction extends BoostAction {

    public AttackBoostAction(Entity entity, int value, int duration) {
        super(entity, value, duration);
    }

    public AttackBoostAction(int priority, int cost, Entity entity, int value, int duration) {
        super(priority, cost, entity, value, duration);
    }

    @Override
    public void execute() {
        createBoost();
        entity.addPowerBoost(boost);

        LOG.info(String.format("%s: Add attack boost (%d, %d) to %s",
                name, boost.getValue(), boost.getDuration(), entity.getName()));
    }

    @Override
    public void undo() {
        entity.removePowerBoost(boost);

        LOG.info(String.format("%s: Remove attack boost (%d, %d) from %s",
                name, boost.getValue(), boost.getDuration(), entity.getName()));
    }
}
