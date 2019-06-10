package ch.heigvd.thecommandmasters.state.game;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.Game.GameScene;
import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.util.LinkedList;

public class GameContext {



    GameLogic gameLogic;
    GameScene gameScene;

    JPanel contentPanel;
    GameState state;
    LinkedList<LinkedList<Command>> selectedCommands;

    static GameContext insance=null;

    public static GameContext getInsance() {
        if(insance == null)
            insance = new GameContext();
        return insance;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
        contentPanel.add(gameScene);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private GameContext() {
        selectedCommands = new LinkedList<>();
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state){
        this.state = state;
        state.doAction(this);
    }

    public LinkedList<LinkedList<Command>> getSelectedCommands() {


        return selectedCommands;
    }

    public void setSelectedCommands(LinkedList<LinkedList<Command>> selectedCommands) {
        this.selectedCommands = selectedCommands;
    }

    public Command[] getSelectedCommandsToArray() {
        Command [] commandsToArray = selectedCommands.toArray(new Command[selectedCommands.size()]);
        return commandsToArray;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }


}
