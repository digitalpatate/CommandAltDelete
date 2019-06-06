package ch.heigvd.thecommandmasters.command.action.boost;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Stat.Boost;
import ch.heigvd.thecommandmasters.Stat.BoostType;
import ch.heigvd.thecommandmasters.command.action.Action;

public abstract class BoostAction extends Action {

    protected final int value;
    protected final int duration;
    protected Boost boost = null;

    protected BoostAction(Entity entity, int value, int duration) {
        super(entity);
        this.value = value;
        this.duration = duration;
    }

    protected void createBoost(BoostType type) {
        boost = new Boost(value, duration, type);
    }
}
