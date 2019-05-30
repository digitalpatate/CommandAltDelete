package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;

import java.util.Queue;

public class ActionSelector {

    private ActionInvoker[] invokers;

    public ActionSelector(int playerCount) {
        this.invokers = new ActionInvoker[playerCount];
    }

    public void setEntityActions(int entityId, Queue<Action> actions) {

        if (entityId < 0 || entityId >= invokers.length) {
            throw new IllegalArgumentException("Entity id must be between 0 and player count");
        }

        invokers[entityId] = new ActionInvoker(actions);
    }

    public boolean isReady() {
        for (int i = 0; i < invokers.length; ++i) {
            if (invokers[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void invokeNext() {

        if (!isReady()) {
            return;
        }

        ActionInvoker next = invokers[0];
        for (int i = 1; i < invokers.length; ++i) {
            if (invokers[i].getPriority() < next.getPriority()) {
                next = invokers[i];
            }
        }
    }
}
