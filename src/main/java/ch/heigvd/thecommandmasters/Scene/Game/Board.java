package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.displayer.Displayer;
import ch.heigvd.thecommandmasters.displayer.DisplayerManager;
import ch.heigvd.thecommandmasters.state.game.GameContext;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements Displayer {
    int mapSize;
    CharacterPanel[] map;
    Board(int mapSize){
        DisplayerManager.setDisplayer(this);
        this.mapSize = mapSize;
        setBackground(Color.DARK_GRAY);
        update();
    }
    private  void reset(){
        removeAll();
        map = new CharacterPanel[mapSize];
        for(int i =0; i< mapSize ;i++){
            CharacterPanel panel = new CharacterPanel();
            add(panel);
            map[i]= panel;
        }
    }
    void update(){
        reset();

        Entity playerOne = GameContext.getInsance().getGameLogic().getPlayer1();
        Entity playerTwo = GameContext.getInsance().getGameLogic().getPlayer2();

        map[playerOne.getPosition()].setEntity(playerOne);
        map[playerTwo.getPosition()].setEntity(playerTwo);

        for(int i =0; i< mapSize ;i++)
            map[i].draw();

        revalidate();
        repaint();
    }

    @Override
    public void showDamage(Entity entity, int amount) {
        update();

    }

    @Override
    public void showHeal(Entity entity, int amount) {
        update();


    }

    @Override
    public void showMovement(Entity entity, int from, int to) {
        update();


    }
}
