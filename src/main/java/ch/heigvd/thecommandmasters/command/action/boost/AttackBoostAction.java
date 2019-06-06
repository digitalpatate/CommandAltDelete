package ch.heigvd.thecommandmasters.command.action.boost;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Stat.BoostType;

public class AttackBoostAction extends BoostAction {

    public AttackBoostAction(Entity entity, int value, int duration) {
        super(entity, value, duration);
    }

    @Override
    public void execute() {
        createBoost(BoostType.ATTACK);
        getEntity().applyAttackBoost(boost);
    }

    @Override
    public void undo() {
        getEntity().removeAttackBoost(boost);
    }
}
