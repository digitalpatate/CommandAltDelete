package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Scene.Game.menu.CommandSelectionPanel;
import ch.heigvd.thecommandmasters.Scene.Game.menu.SelectedCommandPanel;

import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    Dimension dimension;

    Board board;
    CommandSelectionPanel comandSelectionPanel;
    SelectedCommandPanel selectedCommandPanel;

    public GameScene(Dimension dimension){

        System.out.println("IN game");
        this.dimension = dimension;

        this.board = new Board();
        this.comandSelectionPanel = new CommandSelectionPanel();
        this.selectedCommandPanel = new SelectedCommandPanel();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 4;
        c.weighty = 4;
        add(board, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        add(comandSelectionPanel, c);

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 40;      //make this component tall
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        add(selectedCommandPanel, c);


        setPreferredSize(dimension);
    }
}
