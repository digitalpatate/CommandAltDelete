package ch.heigvd.thecommandmasters.command.action.stateffect;

import ch.heigvd.thecommandmasters.Character.Entity;

public class HealthEffectAction extends StatEffectAction {

    public HealthEffectAction(int priority, Entity entity, int value, int duration) {
        super(priority, entity, value, duration);
    }

    @Override
    public void execute() {
        createStatEffect();
        getEntity().applyHealthEffect(statEffect);
    }

    @Override
    public void undo() {
        getEntity().removeHealthEffect(statEffect);
    }
}
