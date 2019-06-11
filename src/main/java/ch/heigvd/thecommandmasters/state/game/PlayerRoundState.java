package ch.heigvd.thecommandmasters.state.game;

public class PlayerRoundState implements GameState {

    GameState nextState;
    public final int PLAYER_ID;

    public PlayerRoundState(GameState nextState,int playerId) {
        this.nextState = nextState;
        this.PLAYER_ID = playerId;
    }

    @Override
    public void doAction(GameContext context) {
        if (PLAYER_ID == 0)
            context.gameScene.updateCommandSelectionPanel(context.gameLogic.getPlayer1());
        else
            context.gameScene.updateCommandSelectionPanel(context.gameLogic.getPlayer2());
    }


        @Override
    public GameState getNextState() {
        return nextState;
    }
}
