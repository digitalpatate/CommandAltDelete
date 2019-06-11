package ch.heigvd.thecommandmasters.command.action.stateffect;

import ch.heigvd.thecommandmasters.Character.Entity;

public class HealthEffectAction extends StatEffectAction {

    public HealthEffectAction(Entity entity, int value, int duration) {
        super(entity, value, duration);
    }

    public HealthEffectAction(int priority, int cost, Entity entity, int value, int duration) {
        super(priority, cost, entity, value, duration);
    }

    @Override
    public void execute() {
        createStatEffect();
        entity.addHealthEffect(statEffect);

        LOG.info(String.format("%s: Add health effect (%d, %d) to %s",
                name, statEffect.getValue(), statEffect.getDuration(), entity.getName()));
    }

    @Override
    public void undo() {
        entity.removeHealthEffect(statEffect);

        LOG.info(String.format("%s (undo): Remove health effect (%d, %d) from %s",
            name, statEffect.getValue(), statEffect.getDuration(), entity.getName()));
    }
}
