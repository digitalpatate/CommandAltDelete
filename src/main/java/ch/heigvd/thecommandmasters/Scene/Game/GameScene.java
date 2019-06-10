package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Scene.Game.menu.CommandSelectionPanel;
import ch.heigvd.thecommandmasters.Scene.Game.menu.EndTurnPanel;
import ch.heigvd.thecommandmasters.Scene.Game.menu.SelectedCommandPanel;
import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameScene extends JPanel {
    Dimension dimension;

    Board board;
    CommandSelectionPanel comandSelectionPanel;
    SelectedCommandPanel selectedCommandPanel;
    EndTurnPanel endTurnPanel;

    public GameScene(Dimension dimension){
        this.dimension = dimension;

        setPreferredSize(dimension);


        this.board = new Board();
        this.comandSelectionPanel = new CommandSelectionPanel();
        this.selectedCommandPanel = new SelectedCommandPanel();
        this.endTurnPanel = new EndTurnPanel();

        setLayout(new GridLayout());


        /*add(board, new GridBagConstraints(0,0,0,0,0.8,1,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));

        add(comandSelectionPanel, new GridBagConstraints(0,1,0,1,0.2,1,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));

        add(selectedCommandPanel, new GridBagConstraints(1,0,1,0,0.8,0.2,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));

        add(endTurnPanel,new GridBagConstraints(1,1,1,1,0.2,0.2,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));*/

        add(board);
        add(selectedCommandPanel);
        add(comandSelectionPanel);
        add(endTurnPanel);
        repaint();
    }

    public void updateCommandSelectionPanel(List<Command> commands) {
        selectedCommandPanel.reset();
        comandSelectionPanel.reset(commands);
        comandSelectionPanel.addCommandListener(command -> {
            selectedCommandPanel.addCommandToList(command.getCommand());
        });
    }

    public Board getBoard() {
        return board;
    }

    public CommandSelectionPanel getComandSelectionPanel() {
        return comandSelectionPanel;
    }

    public SelectedCommandPanel getSelectedCommandPanel() {
        return selectedCommandPanel;
    }

    public EndTurnPanel getEndTurnPanel() {
        return endTurnPanel;
    }
}
