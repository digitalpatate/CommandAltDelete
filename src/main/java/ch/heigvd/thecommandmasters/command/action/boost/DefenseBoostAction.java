package ch.heigvd.thecommandmasters.command.action.boost;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Stat.BoostType;

public class DefenseBoostAction extends BoostAction {

    public DefenseBoostAction(Entity entity, int value, int duration) {
        super(entity, value, duration);
    }

    @Override
    public void execute() {
        createBoost(BoostType.DEFENSE);
        getEntity().applyDefenseBoost(boost);
    }

    @Override
    public void undo() {
        getEntity().removeDefenseBoost(boost);
    }
}
