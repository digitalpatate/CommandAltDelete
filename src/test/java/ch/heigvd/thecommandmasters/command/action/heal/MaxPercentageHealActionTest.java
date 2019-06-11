package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxPercentageHealActionTest {

    @Test
    void itCalculatesHealCorrectly() {

        Entity entity = new Entity(100, 100, 10, 5, "Jack", null);
        entity.damage(25);

        MaxPercentageHealAction action = new MaxPercentageHealAction(entity, 50);

        Assertions.assertEquals(50, action.calculateHeal());
    }
}
