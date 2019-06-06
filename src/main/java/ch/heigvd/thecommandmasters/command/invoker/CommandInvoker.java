package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Command;

/**
 * Manages invoker slaves to chose which command of which entity should be executed.
 * The entity with the lowest priority is the one to invoke its command.
 * If there is a tie, the entity that was invoked the least recently is chosen.
 */
public class CommandInvoker {

    private CommandInvokerSlave[] invokers;
    private int[] invocationOrder;

    /**
     * Creates a new invoker.
     * @param entityCount the number of entity the invoker manages.
     */
    public CommandInvoker(int entityCount) {
        this.invokers = new CommandInvokerSlave[entityCount];
        this.invocationOrder = new int[entityCount];

        // Set a default order
        for (int i = 0; i < entityCount; ++i) {
            invocationOrder[i] = entityCount - i - 1;
        }
    }

    /**
     * Sets the list of command of an entity.
     * @param entityId the entity's ID.
     * @param commands the entity's commands.
     */
    public void setEntityCommands(int entityId, Command[] commands) {

        if (!checkEntityId(entityId)) {
            throw new IllegalArgumentException("Entity id must be in [0 ; entity count[");
        }

        invokers[entityId] = new CommandInvokerSlave(commands);
    }

    /**
     * Resets the invoker. Will be ready to set entities commands.
     */
    public void reset() {
        java.util.Arrays.fill(invokers, null);
    }

    /**
     * Checks if all the entities have their commands set up.
     * @return true if ready.
     */
    public boolean isReady() {
        for (int i = 0; i < invokers.length; ++i) {
            if (invokers[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if there are no more commands to invoke in all the entities.
     * @return true if finished.
     */
    public boolean hasFinished() {

        if (!isReady()) {
            return false;
        }

        for (int i = 0; i < invokers.length; ++i) {
            if (invokers[i].hasNext()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Chooses an invoker slave and invokes his next command.
     * The slave with the lowest priority is the one to invoke its command.
     * If there is a tie, the slave that was invoked the least recently is chosen.
     */
    public void invokeNext() {

        if (!isReady()) {
            return;
        }

        int id = -1;
        int i = 0;

        // Get first invoker with commands
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

                if (invokers[i].hasNext()) {

                    int compare = Integer.compare(invokers[i].getPriority(), invokers[id].getPriority());

                    if (compare == 0) {
                        id = getLeastRecentlyUsedId(new int[]{id, i});

                    } else if (compare < 0) {
                        id = i;
                    }
                }
            }

            updateInvocationOrder(id);
            invokers[id].invokeNext();
        }
    }

    /**
     * Undoes the last command of an entity's opponent.
     * @param entityId the id of the entity.
     */
    public void undoOpponentLast(int entityId) {

        if (checkEntityId(entityId)) {

            for (int i : invocationOrder) {

                if (i != entityId) {
                    invokers[i].undoLast();
                }
            }
        }
    }

    /**
     * Updates the invocation order.
     * @param entityId entity that just invoked an command
     */
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

    /**
     * Gets the least recently used ID of the given ids.
     * @param ids list of ids to checks.
     * @return the least recently used id.
     */
    private int getLeastRecentlyUsedId(int[] ids) {

        for (int i = invocationOrder.length - 1; i >= 0; --i) {
            for (int id : ids) {
                if (id == invocationOrder[i]) {
                    return id;
                }
            }
        }

        throw new RuntimeException("IDs not in invocation order list!");
    }

    /**
     * Check if an id is a correct one.
     * @param id the entity's id.
     * @return true id id is oK.
     */
    private boolean checkEntityId(int id) {
        return id >= 0 && id < invokers.length;
    }

    /**
     * Get the invocation order. Used by tests.
     * @return the invocation order.
     */
    int[] getInvocationOrder() {
        return invocationOrder;
    }
}
