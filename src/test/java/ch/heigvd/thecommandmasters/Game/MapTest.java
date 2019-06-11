package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapTest {

    private Entity entity1, entity2;
    private Map map;

    @BeforeEach
    void createMap() {

        entity1 = new Entity(100, 100, 10, 10, "0", null);
        entity1.setId(0);

        entity2 = new Entity(100, 100, 10, 10, "0", null);
        entity2.setId(1);

        map = new Map(10, entity1, entity2);
    }

    @Test
    void anEntityCanMoveForwardAndBackward() {

        map.move(entity1, 3);
        Assertions.assertEquals(3, entity1.getPosition());

        map.move(entity2, 3);
        Assertions.assertEquals(6, entity2.getPosition());

        map.move(entity1, -3);
        Assertions.assertEquals(0, entity1.getPosition());

        map.move(entity2, -3);
        Assertions.assertEquals(9, entity2.getPosition());
    }

    @Test
    void anEntityCantGetOutOfTheMap() {

        map.move(entity1, -2);
        Assertions.assertEquals(0, entity1.getPosition());

        map.move(entity2, -2);
        Assertions.assertEquals(9, entity2.getPosition());
    }

    @Test
    void EntitiesCantPassThroughEachOther() {

        map.move(entity1, 3);
        map.move(entity2, 3);

        map.move(entity1, 5);
        Assertions.assertEquals(5, entity1.getPosition());

        map.move(entity2, 5);
        Assertions.assertEquals(6, entity2.getPosition());
    }
}
