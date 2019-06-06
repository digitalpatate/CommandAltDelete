package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;

public class GameLogic {

    private Entity player1, player2;
    private Map map;
    private CommandInvoker invoker;

    public GameLogic(Entity player1, Entity player2, int mapSize){
        this.player1 = player1;
        player1.setId(0);

        this.player2 = player2;
        player2.setId(1);

        map = new Map(mapSize, player1, player2);

        invoker = new CommandInvoker(2);
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
