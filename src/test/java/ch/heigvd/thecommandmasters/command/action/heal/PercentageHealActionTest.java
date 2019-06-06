package ch.heigvd.thecommandmasters.command.action.heal;

import ch.heigvd.thecommandmasters.Character.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PercentageHealActionTest {

    @Test
    void itCalculatesHealCorrectly() {

        Entity entity = new Entity(100, 100, 10, 5, "Jack");
        entity.damage(50);

        PercentageHealAction action = new PercentageHealAction(entity, 50);

        Assertions.assertEquals(25, action.calculateHeal());
    }
}
