package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;

/**
 * Manages actions and their priorities. Each actions can be invoked one after an other and
 * the last invoked action can be undone. The invoker's priority changes with each invocations
 * and equals the sum of invoked actions priorities plus the next one's priority.
 * <p>
 * This class is used by the action invoker to chose the salve that will invoke the next action.
 * For example, if each slave corresponds to a player's list of actions, the player with the lowest
 * priority is the next to execute his action.
 *
 * @author Nohan Budry
 */
class ActionInvokerSlave {

    private int current;
    private Action[] actions;

    private int priority;

    /**
     * @param actions array of action to invoke.
     */
    ActionInvokerSlave(Action[] actions) {

        this.current = 0;
        if (actions != null) {
            this.actions = actions;
        }

        this.priority = 0;

        updatePriority();
    }

    /**
     * Retrieves the current priority
     * @return the priority value
     */
    int getPriority() {
        return priority;
    }

    /**
     * Checks if there are more actions to invoke.
     * @return true if there is at least one more action.
     */
    boolean hasNext() {
        return current < actions.length;
    }

    /**
     * Invoke the next action. Nothing happens if there are no more actions.
     * After invoking the action, the priority is updated.
     */
    void invokeNext() {

        if (!hasNext()) {
            return;
        }

        actions[current].execute();
        ++current;

        updatePriority();
    }

    /**
     * Calls undo() in the last invoked action
     */
    void undoLast() {
        if (current > 0) {
            actions[current - 1].undo();
        }
    }

    /**
     * Updates the total priority by adding the priority of the next action with current priority.
     * The priority doesn't change if there are no more actions.
     */
    private void updatePriority() {

        if (hasNext()) {
            priority += actions[current].PRIORITY;
        }
    }
}
