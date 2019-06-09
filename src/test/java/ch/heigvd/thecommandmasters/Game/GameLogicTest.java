package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Character.EntityClass;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameLogicTest {

    private class EntityClassMock extends EntityClass {

        public EntityClassMock(File fileClass, File fileGenericCommand) {
            super(fileClass, fileGenericCommand);
        }

        @Override
        public Entity createEntity() {
            return new Entity(100, 100, 10, 10, "Jack");
        }

        @Override
        public List<Command> createCommands(Entity yourSelf, Entity opponent, Map map, CommandInvoker invoker) {
            return new ArrayList<>();
        }
    }

    @Test
    void itPlaysARoundProperly() {

        File fileClass = new File("./character/archer.json");
        File fileCommand = new File("./baseAction.json");

        EntityClass entityClass = new EntityClassMock(fileClass, fileCommand);

        LinkedList<Integer> order = new LinkedList<>();

        GameLogic game = new GameLogic(entityClass, entityClass, 10);
        Command c1 = new Command(1, 0) {
            @Override
            public void execute() {
                order.add(0);
            }

            @Override
            public void undo() {}
        };
        Command c2 = new Command(2, 0) {
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
