package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Game.Map;

public class MovementAction extends Action {

    private Map map;
    private int movement;

    public MovementAction(Entity entity, Map map, int movement) {
        this(0, 0, entity, map, movement);
    }

    public MovementAction(int priority, int cost, Entity entity, Map map, int movement) {
        super(priority, cost, entity);
        this.map = map;
        this.movement = movement;
    }

    @Override
    public void execute() {
        map.move(entity, movement);
    }

    @Override
    public void undo() {
        map.move(entity, -movement);
    }
}
