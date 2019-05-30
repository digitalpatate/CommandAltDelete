package ch.heigvd.thecommandmasters.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActionTest {

    @Test
    void anActionCanBeExecuted() {

        Value data = new Value(0);
        new DummyAction(data).execute();
        Assertions.assertEquals(1, data.value);
    }

    @Test
    void anActionCanBeUndone() {

        int value = 0;
        Value data = new Value(value);
        DummyAction action = new DummyAction(data);

        action.execute();
        action.undo();

        Assertions.assertEquals(value, data.value);
    }
}
