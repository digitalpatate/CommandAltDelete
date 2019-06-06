package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HealActionTest {

    private static Entity entity;
    private static HealAction action;

    @BeforeAll
    static void setup() {
        entity = new Entity(100, 100, 10, 5, "Jack");
        entity.damage(50);

        action = new HealAction(entity, 10);
    }

    @Test
    void itCalculatesTheHealCorrectly() {
        Assertions.assertEquals(10, action.calculateHeal());
    }

    @Test
    void itCanBeExecutedAndUndone() {

        Assertions.assertEquals(50, entity.getHealth());

        action.execute();
        Assertions.assertEquals(60, entity.getHealth());

        action.undo();
        Assertions.assertEquals(50, entity.getHealth());
    }
}
