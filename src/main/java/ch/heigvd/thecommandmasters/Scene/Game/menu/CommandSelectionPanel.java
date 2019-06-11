package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.Character.Entity;
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

    public void reset(Entity entity) {
        removeAll();

        entity.fillEnergy();

        for (Command command : entity.getCommands()){
            CommandPanel commandPanel = new CommandPanel(command);
            add(commandPanel);
            commandPanel.addCommandListener(e1 -> {
                if (entity.getEnergy() >= command.COST) {
                    entity.changeEnergy(-command.COST);
                    commandListener.action(new CommandSelected(command));
                }
            });
        }
        revalidate();
        repaint();
    }
    public void addCommandListener(CommandListener listener){
        commandListener = listener;
    }

}
