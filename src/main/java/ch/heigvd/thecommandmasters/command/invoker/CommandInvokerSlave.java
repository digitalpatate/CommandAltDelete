package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Command;

/**
 * Manages commands and their priorities. Each commands can be invoked one after an other and
 * the last invoked command can be undone. The invoker's priority changes with each invocations
 * and equals the sum of invoked commands priorities plus the next one's priority.
 * <p>
 * This class is used by the command invoker to chose the salve that will invoke the next command.
 * For example, if each slave corresponds to a player's list of commands, the player with the lowest
 * priority is the next to execute his command.
 */
class CommandInvokerSlave {

    private int current;
    private Command[] commands;

    private int priority;

    /**
     * @param commands array of command to invoke.
     */
    CommandInvokerSlave(Command[] commands) {

        this.current = 0;
        if (commands != null) {
            this.commands = commands;
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
     * Checks if there are more commands to invoke.
     * @return true if there is at least one more command.
     */
    boolean hasNext() {
        return current < commands.length;
    }

    /**
     * Invoke the next command. Nothing happens if there are no more commands.
     * After invoking the command, the priority is updated.
     */
    void invokeNext() {

        if (!hasNext()) {
            return;
        }

        commands[current].execute();
        ++current;

        updatePriority();
    }

    /**
     * Calls undo() in the last invoked command
     */
    void undoLast() {
        if (current > 0) {
            commands[current - 1].undo();
        }
    }

    /**
     * Updates the total priority by adding the priority of the next command with current priority.
     * The priority doesn't change if there are no more commands.
     */
    private void updatePriority() {

        if (hasNext()) {
            priority += commands[current].PRIORITY;
        }
    }
}
