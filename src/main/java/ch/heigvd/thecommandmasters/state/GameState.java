package ch.heigvd.thecommandmasters.state;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.Game.GameScene;

public class GameState implements State {

    @Override
    public void doAction(Context context){

        GameLogic gameLogic = new GameLogic(context.getPlayers().get(0),context.getPlayers().get(1),12);
        GameScene gameScene = new GameScene(context.getContentPanel().getPreferredSize());
        context.getContentPanel().add(gameScene);
        context.getContentPanel().revalidate();
        context.getContentPanel().repaint();
    }
}
