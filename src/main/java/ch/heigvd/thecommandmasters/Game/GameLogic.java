package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Character.EntityClass;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;

public class GameLogic {

    private Entity player1, player2;
    private Map map;
    private CommandInvoker invoker;

    public GameLogic(EntityClass classPlayer1, EntityClass classPlayer2, int mapSize){
        this.player1 = classPlayer1.createEntity();
        player1.setId(0);

        this.player2 = classPlayer2.createEntity();
        player2.setId(1);

        map = new Map(mapSize, player1, player2);

        invoker = new CommandInvoker(2);

        player1.setCommands(classPlayer1.createCommands(player1, player2, map, invoker));
        player2.setCommands(classPlayer1.createCommands(player2, player1, map, invoker));

    }

    public void playRound(Command[] p1Commands, Command[] p2Commands) {

        invoker.setEntityCommands(0, p1Commands);
        invoker.setEntityCommands(1, p2Commands);

        if (invoker.isReady()) {
            while (!invoker.hasFinished()) {
                invoker.invokeNext();
            }
        }

        invoker.reset();
    }
}
