package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.state.game.GameContext;

import javax.swing.*;
import java.awt.*;

public class EndGamePanel extends JPanel {

    public EndGamePanel(){
        setBackground(Color.BLACK);
        add(new JLabel("Winner id " + GameContext.getInsance().getGameLogic().getWinner().getName()));
        revalidate();
        repaint();
    }
}
