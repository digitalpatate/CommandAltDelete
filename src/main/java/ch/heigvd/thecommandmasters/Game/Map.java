package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;

/***
 * Class representing the map logic of the game
 */

public class Map {

    private Entity stage[];
    private Entity p1, p2;
    private int mapSize;


    /***
     * Constructor of Map
     *
     * @param mapSize the size of the map (need to consider only one dimension)
     * @param p1 the first player
     * @param p2 the second player
     */
    public Map(int mapSize, Entity p1, Entity p2) {

        this.mapSize = mapSize;
        stage = new Entity[mapSize];
        this.p1 = p1;
        this.p2 = p2;

        p1.setPosition(0);
        p2.setPosition(mapSize - 1);

        stage[p1.getPosition()] = p1;
        stage[p2.getPosition()] = p2;


    }


    /***
     * Method enabling to move a player at the map
     *
     * @param player the player that will perform the movement
     * @param movement the amount of cases that the player will move
     */
    public void move(Entity player, int movement) {

        int id = player.getId();

        displacement(player, movement, id);


    }

    /***
     *
     * @param player the player that will perform the movement
     * @param movement the amount of cases that the player will move
     * @param id the id of the player
     */
    private void displacement(Entity player, int movement, int id) {
        if (id == 0) {

            playerOneMove(player, movement);

        } else { //player 2

            playerTwoMove(player, movement);

        }
    }

    /***
     *
     * @param player the player that will perform the movement
     * @param movement the amount of cases that the player will move
     */
    private void playerTwoMove(Entity player, int movement) {
        if (movement > 0) {

            if (player.getPosition() - movement > p1.getPosition()) {

                player.move(-movement);

            } else {

                player.setPosition(p1.getPosition() + 1);

            }

        } else {

            if (player.getPosition() - movement <= mapSize - 1) {

                player.move(-movement);

            } else {
                player.setPosition(mapSize - 1);

            }
        }
    }

    /***
     *
     * @param player the player that will perform the movement
     * @param movement the amount of cases that the player will move
     */
    private void playerOneMove(Entity player, int movement) {
        if (movement > 0) {

            if (player.getPosition() + movement < p2.getPosition()) {

                player.move(movement);

            } else {

                player.setPosition(p2.getPosition() - 1);

            }


        } else {

            if (player.getPosition() - movement <= 0) {

                player.move(movement);

            } else {

                player.setPosition(0);

            }

        }
    }


}
