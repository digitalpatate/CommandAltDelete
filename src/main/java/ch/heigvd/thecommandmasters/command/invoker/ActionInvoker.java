package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;

import java.util.Queue;

public class ActionInvoker {

    private Queue<Action> actions;
    private int priority;

    public ActionInvoker(Queue<Action> actions) {

        if (actions != null) {
            this.actions = actions;
        }

        this.priority = 0;

        updatePriority();
    }

    public int getPriority() {
        return priority;
    }

    public boolean hasNext() {
        return actions.isEmpty();
    }

    public void invokeNext() {

        if (!hasNext()) {
            return;
        }

        actions.poll().execute();
        updatePriority();
    }

    private void updatePriority() {

        if (hasNext()) {
            priority += actions.peek().PRIORITY;
        }
    }
}
