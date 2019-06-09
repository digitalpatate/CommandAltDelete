package ch.heigvd.thecommandmasters.command.action.attack;

import ch.heigvd.thecommandmasters.Character.Entity;

public class DefensibleAttackAction extends AttackAction {

    public DefensibleAttackAction(Entity caster, Entity entity,
                                  int percentage, AttackModifier[] modifiers) {
        super(caster, entity, percentage, modifiers);
    }

    public DefensibleAttackAction(int priority, int cost, Entity caster, Entity entity,
                                  int percentage, AttackModifier[] modifiers) {
        super(priority, cost, caster, entity, percentage, modifiers);
    }

    @Override
    protected int calculateDamage() {
        return super.calculateDamage() - entity.getDefense();
    }

    @Override
    protected void updateUsedBoosts() {
        super.updateUsedBoosts();
        entity.updateDefenseBoosts();
    }
}
