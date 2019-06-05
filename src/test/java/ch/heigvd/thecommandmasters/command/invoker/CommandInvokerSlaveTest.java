package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.DummyCommand;
import ch.heigvd.thecommandmasters.command.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandInvokerSlaveTest {

    private Value data;
    private CommandInvokerSlave invokerSlave;

    @BeforeEach
    void setUp() {
        data = new Value(0);

        invokerSlave = new CommandInvokerSlave(new Command[] {
                new DummyCommand(data),
                new DummyCommand(data),
                new DummyCommand(data)
        });
    }

    @Test
    void itCanInvokeEveryCommands() {

        int i = 0;
        while (invokerSlave.hasNext()) {

            invokerSlave.invokeNext();
            Assertions.assertEquals(++i, data.value);
        }
    }

    @Test
    void itCanUndoTheLastCommand() {

        invokerSlave.invokeNext();
        Assertions.assertEquals(1, data.value);

        invokerSlave.undoLast();
        Assertions.assertEquals(0, data.value);
    }

    @Test
    void itsPriorityChangesWithInvocations() {

        int priority = 1;
        // starts with the priority of the first action
        Assertions.assertEquals(priority, invokerSlave.getPriority());

        while (invokerSlave.hasNext()) {
            invokerSlave.invokeNext();

            // The priority changes if there is a next action to invoke
            if (invokerSlave.hasNext()) {
                ++priority;
            }

            Assertions.assertEquals(priority, invokerSlave.getPriority());
        }
    }
}
