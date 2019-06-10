package ch.heigvd.thecommandmasters.state;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.Game.GameScene;
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
        this.simulationState = new SimulationState();
        this.playerTwoRoundState = new PlayerRoundState(simulationState,1);
        this.playerOneRoundState = new PlayerRoundState(playerTwoRoundState,0);
        simulationState.setNextState(playerOneRoundState);
    }

    @Override
    public void doAction(Context context){

        GameLogic gameLogic = new GameLogic(context.getPlayers().get(0),context.getPlayers().get(1),12);

        // HACK:
        this.gameContext = GameContext.getInsance();
        this.gameContext.setContentPanel(context.getContentPanel());
        this.gameContext.setGameLogic(gameLogic);
        this.gameContext.setGameScene(new GameScene(context.getContentPanel().getPreferredSize(),12));
        gameContext.setState(playerOneRoundState);
    }
}
