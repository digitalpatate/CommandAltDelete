package ch.heigvd.thecommandmasters.command;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.action.Action;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;

public class UndoLastAction extends Action {

    private CommandInvoker invoker;

    public UndoLastAction(Entity entity, CommandInvoker invoker) {
        this(0, 0, entity, invoker);
    }

    public UndoLastAction(int priority, int cost, Entity entity, CommandInvoker invoker) {
        super(priority, cost, entity);
        this.invoker = invoker;
    }

    @Override
    public void execute() {
        invoker.undoLastOf(entity.getId());

        LOG.info("Undoing last action of entity #" + entity.getId());
    }

    @Override
    public void undo() {
        LOG.info("'UndoLastAction' can't be undone.");
    }
}
