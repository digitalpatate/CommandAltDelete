package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Scene.Game.menu.CommandSelectionPanel;
import ch.heigvd.thecommandmasters.Scene.Game.menu.EndTurnPanel;
import ch.heigvd.thecommandmasters.Scene.Game.menu.SelectedCommandPanel;
import ch.heigvd.thecommandmasters.state.game.GameContext;

import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    Dimension dimension;

    Board board;
    CommandSelectionPanel commandSelectionPanel;
    SelectedCommandPanel selectedCommandPanel;
    EndTurnPanel endTurnPanel;

    public final int MAP_SIZE;

    public GameScene(Dimension dimension, int mapSize){
        this.dimension = dimension;
        this.MAP_SIZE = mapSize;

        setPreferredSize(dimension);

        this.board = new Board(MAP_SIZE);
        this.commandSelectionPanel = new CommandSelectionPanel();
        this.selectedCommandPanel = new SelectedCommandPanel();
        this.endTurnPanel = new EndTurnPanel();

        setLayout(new GridLayout(4,1,5,5));

        board.setPreferredSize(new Dimension(1000,500));
        setLocation(0,0);

        commandSelectionPanel.setPreferredSize(new Dimension(280,500));
        setLocation(4,0);

        selectedCommandPanel.setPreferredSize(new Dimension(500,220));
        setLocation(0,4);

        endTurnPanel.setPreferredSize(new Dimension(280,220));
        setLocation(4,4);
    }

    public void updateCommandSelectionPanel(Entity entity) {
        System.out.println("updateCommandSelectionPanel");

        selectedCommandPanel.reset();

        commandSelectionPanel.reset(entity);
        commandSelectionPanel.addCommandListener(command ->
            selectedCommandPanel.addCommandToList(command.getCommand()));
    }

    public Board getBoard() {
        return board;
    }

    public CommandSelectionPanel getCommandSelectionPanel() {
        return commandSelectionPanel;
    }

    public SelectedCommandPanel getSelectedCommandPanel() {
        return selectedCommandPanel;
    }

    public EndTurnPanel getEndTurnPanel() {
        return endTurnPanel;
    }
}
