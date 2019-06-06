package ch.heigvd.thecommandmasters.command.action.stateffect;

import ch.heigvd.thecommandmasters.Character.Entity;

public class HealthEffectAction extends StatEffectAction {

    public HealthEffectAction(int priority, Entity entity, int value, int duration) {
        super(priority, entity, value, duration);
    }

    @Override
    public void execute() {
        createStatEffect();
        entity.addHealthEffect(statEffect);
    }

    @Override
    public void undo() {
        entity.removeHealthEffect(statEffect);
    }
}
