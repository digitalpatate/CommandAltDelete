package ch.heigvd.thecommandmasters.command;

import ch.heigvd.thecommandmasters.Entity;

public class MovementAction extends Action {

    private int movement;

    public MovementAction(Entity entity, int movement) {
        super(entity, 1);
        this.movement = movement;
    }

    @Override
    public void execute() {
        System.out.println("move");
        //getEntity().position += movement;
    }

    @Override
    public void undo() {
        System.out.println("und move");
        //getEntity().position -= movement;
    }
}
