package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Action;
import ch.heigvd.thecommandmasters.command.DummyAction;
import ch.heigvd.thecommandmasters.command.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionInvokerTest {

    @Test
    void itIsReadyIfEveryEntityActionsAreSet() {

        int playersCount = 2;
        ActionInvoker invoker = new ActionInvoker(playersCount);

        Assertions.assertFalse(invoker.isReady());

        for (int i = 0; i < playersCount; ++i) {

            Assertions.assertFalse(invoker.isReady());

            invoker.setEntityActions(i, new Action[0]);
        }

        Assertions.assertTrue(invoker.isReady());
    }

    @Test
    void itHasFinishedWhenInvokerSlavesHaveNotMoreActions() {

        int playersCount = 2;
        ActionInvoker invoker = new ActionInvoker(playersCount);

        for (int i = 0; i < playersCount; ++i) {
            invoker.setEntityActions(i, new Action[]{
                    new DummyAction(new Value(0))
            });
        }

        while (!invoker.hasFinished()) {

            Assertions.assertFalse(invoker.hasFinished());

            invoker.invokeNext();
        }

        Assertions.assertTrue(invoker.hasFinished());
    }

    @Test
    void itInvokesAnActionOfTheInvokerSlaveWithTheLowestPriority() {

        Value data0 = new Value(0);
        Value data1 = new Value(0);

        ActionInvoker invoker = new ActionInvoker(2);

        invoker.setEntityActions(0, new Action[] {
                new DummyAction(data0),
                new DummyAction(data0),
        });

        invoker.setEntityActions(1, new Action[] {
                new DummyAction(data1),
                new DummyAction(data1),
        });

        invoker.invokeNext();
        Assertions.assertEquals(1, data0.value);

        invoker.invokeNext();
        Assertions.assertEquals(1, data1.value);

        invoker.invokeNext();
        Assertions.assertEquals(2, data0.value);

        invoker.invokeNext();
        Assertions.assertEquals(2, data1.value);
    }
}
