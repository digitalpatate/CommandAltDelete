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


        setLayout(new GridLayout(3,5,10,10));
    }

    public void reset(List<Command> commands) {
        removeAll();

        for (Command c : commands){
            CommandPanel commandPanel = new CommandPanel(c);
            add(commandPanel);
            commandPanel.addCommandListener(e1 -> {
                commandListener.action(new CommandSelected(c));
                remove(commandPanel);
                repaint();
            });
        }
        revalidate();
        repaint();
    }
    public void addCommandListener(CommandListener listener){
        commandListener = listener;
    }

}
