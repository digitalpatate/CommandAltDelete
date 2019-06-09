package ch.heigvd.thecommandmasters.state;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.CharacterSelection.CharacterSelection;

import javax.swing.*;

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
        System.out.println("Add panel");
        panel[0].addChoseListener(e1 -> {
            context.getPlayers().add(e1.getChosenOne());
            context.setState(nextState);
        });
    }
}
