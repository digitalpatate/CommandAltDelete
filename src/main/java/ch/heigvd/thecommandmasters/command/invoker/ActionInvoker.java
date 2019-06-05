package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;

import java.util.LinkedList;

public class ActionInvoker {

    private ActionInvokerSlave[] invokers;
    private int[] invocationOrder;

    public ActionInvoker(int playerCount) {
        this.invokers = new ActionInvokerSlave[playerCount];
        this.invocationOrder = new int[playerCount];

        // Set a default order
        for (int i = 0; i < playerCount; ++i) {
            invocationOrder[i] = playerCount - i - 1;
        }
    }

    public void setEntityActions(int entityId, Action[] actions) {

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

    public boolean hasFinished() {
        for (int i = 0; i < invokers.length; ++i) {
            if (invokers[i].hasNext()) {
                return false;
            }
        }
        return true;
    }

    public void invokeNext() {

        if (!isReady()) {
            return;
        }

        int id = -1;
        int i = 0;

        // Get first invoker with actions
        for (; i < invokers.length; ++i) {
            if (invokers[i].hasNext()) {
                id = i;
                break;
            }
        }

        if (id >= 0) {

            // Get invoker with lowest priority and least recently used
            ++i;
            for (; i < invokers.length; ++i) {
                int compare = Integer.compare(invokers[i].getPriority(), invokers[id].getPriority());
                if (compare == 0) {
                    id = getLeastRecentlyUsedId(id, i);
                } else if (compare < 0) {
                    id = i;
                }
            }

            updateInvocationOrder(id);
            invokers[id].invokeNext();
        }
    }

    public void undoOpponentLast(int entityId) {

        if (!checkEntityId(entityId)) {
            return;
        }

        for (int i : invocationOrder) {
            if (i != entityId) {
                invokers[i].undoPrevious();
            }
        }
    }

    private void updateInvocationOrder(int entityId) {

        if (!checkEntityId(entityId)) {
            return;
        }

        int currentId = entityId;
        int tmp;

        for (int i = 0; i < invokers.length; ++i) {

            tmp = invocationOrder[i];
            invocationOrder[i] = currentId;
            currentId = tmp;

            if (currentId == entityId) {
                return;
            }
        }
    }

    private int getLeastRecentlyUsedId(int a, int b) {

        for (int i = invokers.length - 1; i >= 0; --i) {
            if (invocationOrder[i] == a) {
                return a;
            } else if (invocationOrder[i] == b) {
                return b;
            }
        }

        return a;
    }

    private boolean checkEntityId(int id) {
        return id >= 0 && id < invokers.length;
    }

    int[] getInvocationOrder() {
        return invocationOrder;
    }
}
