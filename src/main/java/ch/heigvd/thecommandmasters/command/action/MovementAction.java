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

        LOG.info(String.format("%s: Move %s by %d", name, entity.getName(), movement));
    }

    @Override
    public void undo() {
        map.move(entity, -movement);

        LOG.info(String.format("%s (undo): Move %s by %d", name, entity.getName(), -movement));
    }
}
