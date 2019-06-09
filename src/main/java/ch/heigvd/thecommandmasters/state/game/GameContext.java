package ch.heigvd.thecommandmasters.state.game;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.Game.GameScene;

import javax.swing.*;

public class GameContext {



    GameLogic gameLogic;
    GameScene gameScene;

    GameState state;

    public GameContext(JPanel contentPanel,GameLogic gameLogic) {
        this.gameLogic =gameLogic;
        this.gameScene = new GameScene(contentPanel.getPreferredSize());
        contentPanel.add(gameScene);
        contentPanel.revalidate();
        contentPanel.repaint();

    }

    public void setState(GameState state){
        this.state = state;
        state.doAction(this);
    }
}
