package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.Event.CommandListener;
import ch.heigvd.thecommandmasters.Event.CommandSelected;
import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CommandSelectionPanel extends JPanel {
    CommandListener commandListener;

    public CommandSelectionPanel(){

        setBackground(Color.RED);
    }

    public void updateContent(List<Command> commands) {
        for (Command c : commands){
            CommandPanel commandPanel = new CommandPanel(c);
            commandPanel.addCommandListener(e1 -> {
                commandListener.action(new CommandSelected(c));
                remove(commandPanel);
                repaint();
            });
            add(commandPanel);
        }
    }
    public void addCommandListener(CommandListener listener){
        commandListener = listener;
    }

}
