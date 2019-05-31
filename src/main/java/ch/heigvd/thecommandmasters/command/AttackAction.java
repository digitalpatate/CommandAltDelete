package ch.heigvd.thecommandmasters.command;

import ch.heigvd.thecommandmasters.Entity;

public class AttackAction extends Action {

    // TODO change caster to map
    private Entity caster;

    public AttackAction(Entity caster, Entity entity) {
        super(entity, 2);
        this.caster = caster;
    }

    public Entity getCaster() {
        return caster;
    }

    @Override
    public void execute() {
        System.out.println("attack");
        //getEntity().health -= getCaster().strength;
    }

    @Override
    public void undo() {
        System.out.println("undo attack");
        //getEntity().health += getCaster().strength;
    }
}
