package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AttackAction extends Action {

    private class Modifier {

        final int DISTANCE;
        final int PERCENTAGE;

        Modifier(int distance, int percentage) {
            this.DISTANCE = distance;
            this.PERCENTAGE = percentage;
        }
    }

    private Entity caster;
    private final int DEFAULT_PERCENTAGE;
    private Modifier[] modifiers;
    private int lastDamage = 0;

    public AttackAction(Entity caster, Entity entity, JSONObject data) {
        super(2, entity);
        this.caster = caster;

        try {

            this.DEFAULT_PERCENTAGE = (int) data.get("default");
            JSONArray distances = (JSONArray) data.get("distances");
            JSONArray percentages = (JSONArray) data.get("percentages");

            if (distances.size() != percentages.size()) {
                throw new Exception();
            }

            this.modifiers = new Modifier[distances.size()];

            if (modifiers.length > 0) {

                modifiers[0] = new Modifier((int) distances.get(0), (int) percentages.get(0));
                for (int i = 1; i < modifiers.length; ++i) {
                    modifiers[i] = new Modifier((int) distances.get(i), (int) percentages.get(i));
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed parsing attack data!");
        }
    }

    @Override
    public void execute() {
        // TODO: remember effective damage
        getEntity().damage(caster.attack());
    }

    @Override
    public void undo() {
        getEntity().heal(lastDamage);
    }

    private int calculateDamage(int power, int distance) {

        int percentage = DEFAULT_PERCENTAGE;
        int d = 0;

        for (Modifier modifier : modifiers) {

            d += modifier.DISTANCE;

            if (distance <= d) {
                percentage = modifier.PERCENTAGE;
                break;
            }
        }

        return power * percentage / 100;
    }
}
