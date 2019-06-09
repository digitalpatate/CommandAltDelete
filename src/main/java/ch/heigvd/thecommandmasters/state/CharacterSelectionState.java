package ch.heigvd.thecommandmasters.state;

import ch.heigvd.thecommandmasters.Scene.CharacterSelection.CharacterSelection;

public class CharacterSelectionState implements State {
    State nextState;

    public CharacterSelectionState(State nextState) {
        this.nextState =nextState;
    }

    @Override
    public void doAction(Context context){
        final CharacterSelection[] panel = {new CharacterSelection(context.getContentPanel().getPreferredSize())};
        context.getContentPanel().add(panel[0]);
        context.getContentPanel().revalidate();
        context.getContentPanel().repaint();
        panel[0].addChoseListener(e1 -> {
            context.getPlayers().add(e1.getChosenOne());
            context.setState(nextState);
        });
    }
}
