package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;

import java.util.Queue;

public class ActionInvoker {

    private ActionInvokerSlave[] invokers;

    public ActionInvoker(int playerCount) {
        this.invokers = new ActionInvokerSlave[playerCount];
    }

    public void setEntityActions(int entityId, Queue<Action> actions) {

        if (entityId < 0 || entityId >= invokers.length) {
            throw new IllegalArgumentException("Entity id must be in [0 ; player count[");
        }

        invokers[entityId] = new ActionInvokerSlave(actions);
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

        ActionInvokerSlave next = invokers[0];
        for (int i = 1; i < invokers.length; ++i) {
            if (invokers[i].getPriority() < next.getPriority()) {
                next = invokers[i];
            }
        }
    }
}
