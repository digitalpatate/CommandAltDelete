package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class GameLogicTest {

    @Test
    void itPlaysARoundProperly() {

        Entity player1 = new Entity(100, 100, 10, 10, "Jack");
        Entity player2 = new Entity(100, 100, 10, 10, "Jack");

        LinkedList<Integer> order = new LinkedList<>();

        GameLogic game = new GameLogic(player1, player2, 10);
        Command c1 = new Command(1) {
            @Override
            public void execute() {
                order.add(0);
            }

            @Override
            public void undo() {}
        };
        Command c2 = new Command(2) {
            @Override
            public void execute() {
                order.add(1);
            }

            @Override
            public void undo() {}
        };

        game.playRound(new Command[] {c1, c1, c1, c1}, new Command[] {c2, c2});

        Assertions.assertArrayEquals(new Integer[] {0, 1, 0, 0, 1, 0}, order.toArray());
    }
}
