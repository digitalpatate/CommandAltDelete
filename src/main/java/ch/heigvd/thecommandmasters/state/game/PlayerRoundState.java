package ch.heigvd.thecommandmasters.state.game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Scene.Game.GameScene;
import ch.heigvd.thecommandmasters.displayer.DisplayerManager;

import java.awt.*;

public class PlayerRoundState implements GameState {

    GameState nextState;
    public final int PLAYER_ID;

    public PlayerRoundState(GameState nextState,int playerId) {
        this.nextState = nextState;
        this.PLAYER_ID = playerId;
    }

    @Override
    public void doAction(GameContext context) {

        Entity player =  PLAYER_ID == 0 ? context.gameLogic.getPlayer1() : context.gameLogic.getPlayer2();
        GameScene scene = context.getGameScene();

        DisplayerManager.setDisplayer(scene.getBoard());
        scene.updateCommandSelectionPanel(player);

        scene.removeAll();

        scene.setLayout(new GridLayout(4,1,5,5));

        scene.add(scene.getBoard());
        scene.add(scene.getSelectedCommandPanel());
        scene.add(scene.getCommandSelectionPanel());
        scene.add(scene.getEndTurnPanel());

        scene.revalidate();
        scene.repaint();
    }

        @Override
    public GameState getNextState() {
        return nextState;
    }
}
