package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import static ch.heigvd.thecommandmasters.state.game.GameContext.*;

public class EndTurnPanel extends JPanel {

    public EndTurnPanel() {


        JButton button = new JButton("End turn");
        add(button);
        repaint();
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("End turn");
                // TODO find better way than clone!
                getInsance().getSelectedCommands().add(
                        (LinkedList<Command>) getInsance().getGameScene().getSelectedCommandPanel().getCommands().clone()
                );
                getInsance().setState(getInsance().getState().getNextState());
            }
        });
    }


}
