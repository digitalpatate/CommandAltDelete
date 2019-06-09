package ch.heigvd.thecommandmasters.state.game;


public class PlayerRoundState implements GameState {

    GameState nextState;

    public PlayerRoundState(GameState nextState) {
        this.nextState = nextState;
    }

    @Override
    public void doAction(GameContext context) {
        context.gameScene.updateCommandSelectionPanel(context.gameLogic.getPlayer1().getCommands());

       //context.setState(nextState);
    }
}
