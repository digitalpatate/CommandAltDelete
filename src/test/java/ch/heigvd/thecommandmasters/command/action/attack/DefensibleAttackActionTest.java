package ch.heigvd.thecommandmasters.command.action.attack;

import ch.heigvd.thecommandmasters.Character.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefensibleAttackActionTest {

    private Entity jack, steve;
    private DefensibleAttackAction action;

    @BeforeEach
    void setup() {
        jack = new Entity(100, 100, 10, 5, "Jack", null);
        steve = new Entity(100, 100, 10, 5, "Steve", null);
        action = new DefensibleAttackAction(jack, steve, 100, new AttackModifier[] {});
    }

    @Test
    void itCalculatesDamageCorrectly() {

        Assertions.assertEquals(5, action.calculateDamage());

        action = new DefensibleAttackAction(jack, steve, 40, new AttackModifier[] {
                new AttackModifier(1, 100),
                new AttackModifier(2, 80),
                new AttackModifier(3, 60),
        });

        steve.setPosition(1);
        Assertions.assertEquals(5, action.calculateDamage());
        steve.setPosition(2);
        Assertions.assertEquals(3, action.calculateDamage());
        steve.setPosition(5);
        Assertions.assertEquals(1, action.calculateDamage());
        steve.setPosition(8);
        Assertions.assertEquals(-1, action.calculateDamage());
    }
}
