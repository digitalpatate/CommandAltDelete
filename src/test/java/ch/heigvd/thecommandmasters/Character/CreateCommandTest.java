package ch.heigvd.thecommandmasters.Character;

import ch.heigvd.thecommandmasters.Game.Map;
import ch.heigvd.thecommandmasters.command.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

        List<Command> c1 = ec.getCommandClass(e1, e2, map);

        Assertions.assertEquals(12, c1.size());
    }

}
