package ch.heigvd.thecommandmasters.state.game;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.command.Command;

import static ch.heigvd.thecommandmasters.state.game.GameContext.*;

public class SimulationState implements GameState {
    GameState nextState;

    public SimulationState(GameState nextState) {
        this.nextState = nextState;
    }

    @Override
    public void doAction(GameContext context) {
        GameLogic gameLogic = getInsance().gameLogic;
        gameLogic.playRound(
                getInsance().getSelectedCommands().get(0).toArray(new Command[getInsance().getSelectedCommands().get(0).size()]),
                getInsance().getSelectedCommands().get(1).toArray(new Command[getInsance().getSelectedCommands().get(1).size()])
        );
        getInsance().getGameScene().getBoard().playSimulation(gameLogic);
    }


    @Override
    public GameState getNextState() {
        return nextState;
    }
}


