package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;

public class MaxPercentageHealAction extends HealAction {

    public MaxPercentageHealAction(Entity entity, int value) {
        super(entity, value);
    }

    @Override
    protected int calculateHeal() {
        return entity.getMaxHealth() * value / 100;
    }
}
