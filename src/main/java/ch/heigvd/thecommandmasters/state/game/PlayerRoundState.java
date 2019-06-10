package ch.heigvd.thecommandmasters.state.game;

public class PlayerRoundState implements GameState {

    GameState nextState;
    int playerId;

    public PlayerRoundState(GameState nextState,int playerId) {
        this.nextState = nextState;
        this.playerId = playerId;
    }

    @Override
    public void doAction(GameContext context) {
        if (playerId == 0)
            context.gameScene.updateCommandSelectionPanel(context.gameLogic.getPlayer1().getCommands());
        else
            context.gameScene.updateCommandSelectionPanel(context.gameLogic.getPlayer2().getCommands());
    }


        @Override
    public GameState getNextState() {
        return nextState;
    }
}
