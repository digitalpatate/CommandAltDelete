package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
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

        LOG.info(String.format("%s: Undo last action of %s", name, entity.getName()));
    }

    @Override
    public void undo() {
        LOG.info(String.format("%s (undo): Can't be undone.", name));
    }
}
