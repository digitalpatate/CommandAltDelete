package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;

public class ActionInvoker {

    private ActionInvokerSlave[] invokers;

    public ActionInvoker(int playerCount) {
        this.invokers = new ActionInvokerSlave[playerCount];
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

        int i = 0;
        ActionInvokerSlave invoker = null;

        // Get the first invoker slave with actions
        for (; i < invokers.length; ++i) {
            if (invokers[i].hasNext()) {
                invoker = invokers[i];
                break;
            }
        }

        if (invoker != null) {
            for (;i < invokers.length; ++i) {

                // Ignore invokers without actions
                if (invokers[i].hasNext()) {

                    // TODO what to do if equal priority?

                    if (invokers[i].getPriority() < invoker.getPriority()) {
                        invoker = invokers[i];
                    }
                }
            }

            invoker.invokeNext();
        }
    }
}
