package ch.heigvd.thecommandmasters.Scene.Game.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static ch.heigvd.thecommandmasters.state.game.GameContext.*;

public class EndTurnPanel extends JPanel {

    public EndTurnPanel() {
        setBackground(Color.blue);

        JButton button = new JButton("End turn");
        add(button);
        repaint();
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("End turn");
                getInsance().getSelectedCommands().add(getInsance().getGameScene().getSelectedCommandPanel().getCommands());
                getInsance().setState(getInsance().getState().getNextState());
            }
        });
    }


}
