package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Game.Map;

public class MovementAction extends Action {

    private Map map;
    private int movement;

    public MovementAction(Entity entity, int movement) {
        super(1, entity);
        this.movement = movement;
    }

    @Override
    public void execute() {
        map.move(getEntity(), movement);
    }

    @Override
    public void undo() {
        map.move(getEntity(), movement);
    }
}
