package ch.heigvd.thecommandmasters.Character;

import ch.heigvd.thecommandmasters.Game.Map;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class CreateCommandTest {

    @Test
    public void GoodCommandForEntityClass(){
        File fileClass = new File("./character/archer.json");
        File fileCommand = new File("./baseAction.json");

        EntityClass ec = new EntityClass(fileClass, fileCommand);
        Entity e1 = ec.createEntity();
        Entity e2 = ec.createEntity();
        Map map = new Map(20, e1, e2);

        CommandInvoker invoker = new CommandInvoker(2);

        List<Command> c1 = ec.createCommands(e1, e2, map, invoker);

        Assertions.assertEquals(13, c1.size());
    }
}
