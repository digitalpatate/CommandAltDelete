package ch.heigvd.thecommandmasters.state.game;

public class SimulationState implements GameState {
    GameState nextState;

    public SimulationState(GameState nextState) {
        this.nextState = nextState;
    }

    @Override
    public void doAction(GameContext context) {

        context.setState(nextState);
    }
}
