package ch.heigvd.thecommandmasters.state.game;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.Game.EndGamePanel;
import ch.heigvd.thecommandmasters.Scene.Game.menu.EndTurnPanel;
import ch.heigvd.thecommandmasters.command.Command;

import static ch.heigvd.thecommandmasters.state.game.GameContext.*;

public class SimulationState implements GameState {
    GameState nextState;

    public SimulationState() {
    }

    @Override
    public void doAction(GameContext context) {

        GameLogic gameLogic = getInsance().gameLogic;
        System.out.println(getInsance().getSelectedCommands());
        gameLogic.playRound(
                getInsance().getSelectedCommands().get(0).toArray(new Command[getInsance().getSelectedCommands().get(0).size()]),
                getInsance().getSelectedCommands().get(1).toArray(new Command[getInsance().getSelectedCommands().get(1).size()])
        );
        if(gameLogic.hasWinner()){
            getInsance().getGameScene().removeAll();
            getInsance().getGameScene().add(new EndGamePanel());
            getInsance().getGameScene().revalidate();
            getInsance().getGameScene().repaint();
        }
        getInsance().getSelectedCommands().clear();
        getInsance().getGameScene().getSelectedCommandPanel().reset();



    }

    public void setNextState(GameState nextState) {
        this.nextState = nextState;
    }

    @Override
    public GameState getNextState() {
        return nextState;
    }
}


