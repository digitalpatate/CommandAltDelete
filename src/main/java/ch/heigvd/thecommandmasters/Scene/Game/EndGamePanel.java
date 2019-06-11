package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.state.game.GameContext;

import javax.swing.*;
import java.awt.*;

public class EndGamePanel extends JPanel {

    public EndGamePanel(){
        GameContext.getInsance().getGameScene().setLayout(new GridLayout(1,1));

        JLabel label = new JLabel("The Winner is the " + GameContext.getInsance().getGameLogic().getWinner().getName());

        add(label);
        revalidate();
        repaint();
    }
}
