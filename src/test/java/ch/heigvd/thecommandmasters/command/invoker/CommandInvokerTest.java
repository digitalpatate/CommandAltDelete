package ch.heigvd.thecommandmasters.command.invoker;

import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.DummyCommand;
import ch.heigvd.thecommandmasters.command.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandInvokerTest {

    @Test
    void itIsReadyIfEveryEntityCommandsAreSet() {

        int playersCount = 2;
        CommandInvoker invoker = new CommandInvoker(playersCount);

        Assertions.assertFalse(invoker.isReady());

        for (int i = 0; i < playersCount; ++i) {

            Assertions.assertFalse(invoker.isReady());

            invoker.setEntityCommands(i, new Command[0]);
        }

        Assertions.assertTrue(invoker.isReady());
    }

    @Test
    void itHasFinishedWhenInvokerSlavesHaveNoMoreCommands() {

        int playersCount = 2;
        CommandInvoker invoker = new CommandInvoker(playersCount);

        for (int i = 0; i < playersCount; ++i) {
            invoker.setEntityCommands(i, new Command[]{
                    new DummyCommand(new Value(0))
            });
        }

        while (!invoker.hasFinished()) {

            Assertions.assertFalse(invoker.hasFinished());

            invoker.invokeNext();
        }

        Assertions.assertTrue(invoker.hasFinished());
    }

    @Test
    void itInvokesAnCommandOfTheInvokerSlaveWithTheLowestPriority() {

        Value data0 = new Value(0);
        Value data1 = new Value(0);

        CommandInvoker invoker = new CommandInvoker(2);

        invoker.setEntityCommands(0, new Command[] {
                new DummyCommand(data0),
                new DummyCommand(data0),
        });

        invoker.setEntityCommands(1, new Command[] {
                new DummyCommand(data1),
                new DummyCommand(data1),
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

    @Test
    void itUpdatesInvocationOrderProperly() {

        Value data = new Value(0);

        CommandInvoker invoker = new CommandInvoker(3);

        invoker.setEntityCommands(0, new Command[] {
                new DummyCommand(data),
                new DummyCommand(data),
                new DummyCommand(data),
        });

        invoker.setEntityCommands(1, new Command[] {
                new DummyCommand(data),
                new DummyCommand(data),
                new DummyCommand(data),
        });

        invoker.setEntityCommands(2, new Command[] {
                new DummyCommand(3, data)
        });

        Assertions.assertArrayEquals(new int[] {2, 1, 0}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {0, 2, 1}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {1, 0, 2}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {0, 1, 2}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {1, 0, 2}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {2, 1, 0}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {0, 2, 1}, invoker.getInvocationOrder());

        invoker.invokeNext();
        Assertions.assertArrayEquals(new int[] {1, 0, 2}, invoker.getInvocationOrder());
    }

    @Test
    void itCanUndoAnOpponentLastCommand() {

        Value data0 = new Value(0);
        Value data1 = new Value(0);

        CommandInvoker invoker = new CommandInvoker(2);

        invoker.setEntityCommands(0, new Command[] {
                new DummyCommand(data0),
                new DummyCommand(data0),
        });

        invoker.setEntityCommands(1, new Command[] {
                new DummyCommand(2, data1),
        });

        invoker.invokeNext();
        invoker.invokeNext();
        invoker.invokeNext();
        invoker.undoLastOf(0);

        Assertions.assertEquals(1, data0.value);
    }
}
