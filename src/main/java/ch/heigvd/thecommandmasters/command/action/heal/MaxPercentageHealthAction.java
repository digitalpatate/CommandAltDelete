package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;

public class MaxPercentageHealthAction extends HealAction {

    public MaxPercentageHealthAction(Entity entity, int value) {
        super(entity, value);
    }

    @Override
    protected int calculateHeal() {
        return entity.getMaxHealth() * value / 100;
    }
}
