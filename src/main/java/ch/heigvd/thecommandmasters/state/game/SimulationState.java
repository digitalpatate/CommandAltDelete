package ch.heigvd.thecommandmasters.state.game;

import ch.heigvd.thecommandmasters.Scene.Game.GameScene;
import ch.heigvd.thecommandmasters.Scene.Game.simulation.SimulationPanel;
import ch.heigvd.thecommandmasters.command.Command;

import java.awt.*;

public class SimulationState implements GameState {

    GameState nextState;

    public SimulationState() {}

    @Override
    public void doAction(GameContext context) {

        GameContext gameContext = GameContext.getInsance();
        GameScene gameScene = gameContext.gameScene;
        SimulationPanel simulationPanel = new SimulationPanel();

        gameScene.removeAll();

        gameScene.setLayout(new GridLayout(1, 1));
        gameScene.add(simulationPanel);

        gameScene.revalidate();
        gameScene.repaint();

        new Thread(() -> {
            simulationPanel.playSimulation(
                    gameContext.getSelectedCommands().get(0).toArray(new Command[gameContext.getSelectedCommands().get(0).size()]),
                    gameContext.getSelectedCommands().get(1).toArray(new Command[gameContext.getSelectedCommands().get(1).size()])
            );
        }).start();
    }

    public void setNextState(GameState nextState) {
        this.nextState = nextState;
    }

    @Override
    public GameState getNextState() {
        return nextState;
    }
}


