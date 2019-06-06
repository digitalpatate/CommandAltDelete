package ch.heigvd.thecommandmasters.command.action.attack;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Stat.Boost;
import ch.heigvd.thecommandmasters.Stat.BoostType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttackActionTest {

    private Entity jack, steve;
    private AttackAction action;

    @BeforeEach
    void setup() {
        jack = new Entity(100, 100, 10, 5, "Jack");
        steve = new Entity(100, 100, 10, 5, "Steve");
        action = new AttackAction(jack, steve, 100, new AttackModifier[] {});
    }

    @Test
    void itCalculatesTheDamageCorrectly() {

        Assertions.assertEquals(10, action.calculateDamage());

        action = new AttackAction(jack, steve, 40, new AttackModifier[] {
            new AttackModifier(1, 100),
            new AttackModifier(2, 80),
            new AttackModifier(3, 60),
        });

        steve.setPosition(1);
        Assertions.assertEquals(10, action.calculateDamage());
        steve.setPosition(2);
        Assertions.assertEquals(8, action.calculateDamage());
        steve.setPosition(5);
        Assertions.assertEquals(6, action.calculateDamage());
        steve.setPosition(8);
        Assertions.assertEquals(4, action.calculateDamage());
    }

    @Test
    void itCantInflictNegativeDamage() {
        action = new AttackAction(jack, steve, -100, new AttackModifier[] {});
        Assertions.assertEquals(-10, action.calculateDamage());

        action.execute();
        Assertions.assertEquals(100, jack.getHealth());
    }

    @Test
    void itInflictsDamageWhenExecuted() {
        action.execute();
        Assertions.assertEquals(90, steve.getHealth());
    }

    @Test
    void itCanUndoTheDamage() {
        action.execute();
        action.undo();
        Assertions.assertEquals(100, steve.getHealth());
    }

    @Test
    void itReducesBoostsDurationWhenExecuted() {

        jack.addPowerBoost(new Boost(10, 1, BoostType.ATTACK));
        Assertions.assertEquals(20, jack.getPower());

        action.execute();
        Assertions.assertEquals(10, jack.getPower());
    }
}
