package ch.heigvd.thecommandmasters.command.action.attack;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.action.Action;

public class AttackAction extends Action {

    public class Modifier {

        final int DISTANCE;
        final int PERCENTAGE;

        Modifier(int distance, int percentage) {
            this.DISTANCE = distance;
            this.PERCENTAGE = percentage;
        }
    }

    protected final Entity caster;
    private final int defaultPercentage;
    private Modifier[] modifiers;

    private int damage = 0;

    public AttackAction(Entity caster, Entity entity, int percentage, Modifier[] modifiers) {
        super(2, entity);
        this.caster = caster;
        this.defaultPercentage = percentage;
        this.modifiers = modifiers;
    }

    @Override
    final public void execute() {

        damage = calculateDamage();

        entity.damage(damage);

        updateUsedBoosts();

        LOG.info(String.format(
                "%s received %d damage from %s.",
                entity.getName(), damage, caster.getName()
        ));
    }

    @Override
    final public void undo() {
        entity.heal(damage);
    }

    private int calculatePercentage() {

        int distance = Math.abs(caster.getPosition() - entity.getPosition());
        int percentage = defaultPercentage;
        int d = 0;

        for (Modifier modifier : modifiers) {

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

//        try {
//
//            this.DEFAULT_PERCENTAGE = (int) data.get("default");
//            JSONArray distances = (JSONArray) data.get("distances");
//            JSONArray percentages = (JSONArray) data.get("percentages");
//
//            if (distances.size() != percentages.size()) {
//                throw new Exception();
//            }
//
//            this.modifiers = new Modifier[distances.size()];
//
//            if (modifiers.length > 0) {
//
//                modifiers[0] = new Modifier((int) distances.get(0), (int) percentages.get(0));
//                for (int i = 1; i < modifiers.length; ++i) {
//                    modifiers[i] = new Modifier((int) distances.get(i), (int) percentages.get(i));
//                }
//            }
//
//        } catch (Exception e) {
//            throw new IllegalArgumentException("Failed parsing attack data!");
//        }
