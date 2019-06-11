package ch.heigvd.thecommandmasters.state.game;


public interface GameState {
    public void doAction(GameContext context);

    public GameState getNextState();
}
