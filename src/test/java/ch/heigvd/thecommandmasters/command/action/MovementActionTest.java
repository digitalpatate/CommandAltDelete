package ch.heigvd.thecommandmasters.command.action;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Game.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MovementActionTest {

    private static Entity entity;
    private static MovementAction action;

    @BeforeAll
    static void setup() {

        entity = new Entity(100, 100, 10, 10, "Jack");
        entity.setId(0);

        Entity entity2 = new Entity(100, 100, 10, 10, "Steve");
        entity2.setId(1);

        Map map = new Map(10, entity, entity2);

        action = new MovementAction(entity, map, 2);
    }

    @Test
    void itCanBeExecutedAndUndone() {

        Assertions.assertEquals(0, entity.getPosition());

        action.execute();
        Assertions.assertEquals(2, entity.getPosition());

        action.undo();
        Assertions.assertEquals(0, entity.getPosition());
    }
}
