package ch.heigvd.thecommandmasters.state;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.state.game.GameContext;
import ch.heigvd.thecommandmasters.state.game.PlayerRoundState;
import ch.heigvd.thecommandmasters.state.game.SimulationState;

public class GameState implements State {

    GameContext gameContext;

    PlayerRoundState playerOneRoundState;
    PlayerRoundState playerTwoRoundState;

    SimulationState simulationState;

    public GameState() {
        this.gameContext = null;
        this.simulationState = new SimulationState(playerOneRoundState);
        this.playerTwoRoundState = new PlayerRoundState(simulationState);
        this.playerOneRoundState = new PlayerRoundState(playerTwoRoundState);
    }

    @Override
    public void doAction(Context context){

        GameLogic gameLogic = new GameLogic(context.getPlayers().get(0),context.getPlayers().get(1),12);

        // HACK:
        this.gameContext = new GameContext(context.getContentPanel(),gameLogic);
        gameContext.setState(playerOneRoundState);
    }
}
