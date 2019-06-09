package ch.heigvd.thecommandmasters.command.action.stateffect;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Stat.StatEffect;
import ch.heigvd.thecommandmasters.command.action.Action;

public abstract class StatEffectAction extends Action {

    private final int value;
    private final int duration;
    protected StatEffect statEffect = null;

    public StatEffectAction(Entity entity, int value, int duration) {
        this(0, 0, entity, value, duration);
    }

    public StatEffectAction(int priority, int cost, Entity entity, int value, int duration) {
        super(priority, cost, entity);
        this.value = value;
        this.duration = duration;
    }

    protected void createStatEffect() {
        statEffect = new StatEffect(value, duration);
    }
}
