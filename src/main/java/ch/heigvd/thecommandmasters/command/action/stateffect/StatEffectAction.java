package ch.heigvd.thecommandmasters.command.action.stateffect;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Stat.StatEffect;
import ch.heigvd.thecommandmasters.command.action.Action;

public abstract class StatEffectAction extends Action {

    private final int value;
    private final int duration;
    protected StatEffect statEffect = null;

    public StatEffectAction(int priority, Entity entity, int value, int duration) {
        super(priority, entity);
        this.value = value;
        this.duration = duration;
    }

    protected void createStatEffect() {
        statEffect = new StatEffect(value, duration);
    }
}
