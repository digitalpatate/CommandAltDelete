package ch.heigvd.thecommandmasters.command.action.attack;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.action.Action;

public class AttackAction extends Action {

    protected final Entity caster;
    private final int defaultPercentage;
    private AttackModifier[] modifiers;

    private int damage = 0;

    public AttackAction(Entity caster, Entity entity,
                        int percentage, AttackModifier[] modifiers) {
        this(0, 0, caster, entity, percentage, modifiers);
    }

    public AttackAction(int priority, int cost, Entity caster, Entity entity,
                        int percentage, AttackModifier[] modifiers) {
        super(priority, cost, entity);
        this.caster = caster;
        this.defaultPercentage = percentage;
        this.modifiers = modifiers;
    }

    @Override
    final public void execute() {

        damage = calculateDamage();

        if (entity.damage(damage)) {

            updateUsedBoosts();

            LOG.info(String.format("%s: %s received %d damage from %s.",
                    name, entity.getName(), damage, caster.getName()));
        }
    }

    @Override
    final public void undo() {

        // TODO: restore duration of boosts? Nope!

        if (entity.heal(damage)) {

            LOG.info(String.format("%s (undo): %s's attack undone. %s gained %d health.",
                    name, caster.getName(), entity.getName(), damage));
        }
    }

    private int calculatePercentage() {

        int distance = Math.abs(caster.getPosition() - entity.getPosition());
        int percentage = defaultPercentage;
        int d = 0;

        for (AttackModifier modifier : modifiers) {

            d += modifier.DISTANCE;

            if (distance <= d) {
                percentage = modifier.PERCENTAGE;
                break;
            }
        }

        return percentage;
    }

    protected int calculateDamage() {
        return caster.getPower() * calculatePercentage() / 100;
    }

    protected void updateUsedBoosts() {
        caster.updatePowerBoosts();
    }
}
