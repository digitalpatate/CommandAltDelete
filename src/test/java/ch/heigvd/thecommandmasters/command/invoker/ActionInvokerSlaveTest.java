package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;
import ch.heigvd.thecommandmasters.command.DummyAction;
import ch.heigvd.thecommandmasters.command.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActionInvokerSlaveTest {

    Value data;
    ActionInvokerSlave invokerSlave;

    @BeforeEach
    void setUp() {
        data = new Value(0);

        invokerSlave = new ActionInvokerSlave(new Action[] {
                new DummyAction(data),
                new DummyAction(data),
                new DummyAction(data)
        });
    }

    @Test
    void itCanInvokeEveryActions() {

        int i = 0;
        while (invokerSlave.hasNext()) {

            invokerSlave.invokeNext();
            Assertions.assertEquals(++i, data.value);
        }
    }

    @Test
    void itCanUndoThePreviousAction() {

        invokerSlave.invokeNext();
        Assertions.assertEquals(1, data.value);

        invokerSlave.undoPrevious();
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
