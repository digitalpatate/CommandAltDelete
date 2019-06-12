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
        player2.setCommands(classPlayer2.createCommands(player2, player1, map, invoker));

    }

    public void setupRound(Command[] p1Commands, Command[] p2Commands) {
        invoker.setEntityCommands(0, p1Commands);
        invoker.setEntityCommands(1, p2Commands);
    }

    public void endRound() {
        invoker.reset();
    }

    public void nextAction() {
        if (invoker.isReady() && !invoker.hasFinished()) {
            invoker.invokeNext();
            (invoker.getLastEntityId() == 0 ? getPlayer1() : getPlayer2()).updateHealthEffects();
        }
    }

    public boolean hasWinner() {
        return player1.getHealth() <= 0 || player2.getHealth() <= 0;
    }

    public Entity getWinner() {

        if (!hasWinner()) {
            return null;
        }

        return player1.getHealth() <= 0 ? player2 : player1;
    }

    public boolean hasFinished() {
        return invoker.hasFinished();
    }

    public Entity getPlayer1() {
        return player1;
    }

    public void setPlayer1(Entity player1) {
        this.player1 = player1;
    }

    public Entity getPlayer2() {
        return player2;
    }

    public void setPlayer2(Entity player2) {
        this.player2 = player2;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
