package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;

public class PercentageHealAction extends HealAction {

    public PercentageHealAction(Entity entity, int value) {
        super(entity, value);
    }

    public PercentageHealAction(int priority, int cost, Entity entity, int value) {
        super(priority, cost, entity, value);
    }

    @Override
    protected int calculateHeal() {
        return entity.getHealth() * value / 100;
    }
}
