package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Character.EntityClass;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;

/***
 * Class representing the logic of the game, its defines the round
 */
public class GameLogic {

    private Entity player1, player2;
    private Map map;
    private CommandInvoker invoker;


    /***
     * Constructor
     *
     * @param classPlayer1 Class of the first player
     * @param classPlayer2 Class of the second player
     * @param mapSize size of the map
     */
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

    /***
     * Restarts the invoker
     */
    public void endRound() {
        invoker.reset();
    }

    /***
     *
     */
    public void nextAction() {
        if (invoker.isReady() && !invoker.hasFinished()) {
            invoker.invokeNext();
            (invoker.getLastEntityId() == 0 ? getPlayer1() : getPlayer2()).updateHealthEffects();
        }
    }

    public boolean hasWinner() {
        return player1.getHealth() <= 0 || player2.getHealth() <= 0;
    }

    /***
     *
     * @return the winner
     */
    public Entity getWinner() {

        if (!hasWinner()) {
            return null;
        }

        return player1.getHealth() <= 0 ? player2 : player1;
    }

    /***
     *
     * @return true is there are no more commands to execute
     */
    public boolean hasFinished() {
        return invoker.hasFinished();
    }

    /***
     *
     * @return player 1
     */
    public Entity getPlayer1() {
        return player1;
    }

    /***
     *
     * @param player1  the first player
     */
    public void setPlayer1(Entity player1) {
        this.player1 = player1;
    }

    /***
     *
     * @return player 2
     */
    public Entity getPlayer2() {
        return player2;
    }

    /***
     *
     * @param player2 the second player
     */
    public void setPlayer2(Entity player2) {
        this.player2 = player2;
    }

    /***
     *
     * @return the game map
     */
    public Map getMap() {
        return map;
    }

    /***
     *
     * @param map the game map
     */
    public void setMap(Map map) {
        this.map = map;
    }
}
