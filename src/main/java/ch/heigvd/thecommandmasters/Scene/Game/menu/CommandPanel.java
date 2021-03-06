package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.Event.CommandListener;
import ch.heigvd.thecommandmasters.Event.CommandSelected;
import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CommandPanel extends JPanel implements MouseListener {
    Command command;
    CommandListener commandListener;

    public CommandPanel(Command command) {

        this.command = command;
        addMouseListener(this);
        setLayout(new GridLayout(3,1));
        setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
        setBackground(Color.white);
        JLabel commandName = new JLabel(command.name);
        JLabel commandCost = new JLabel("Cost : "+command.COST);
        JLabel commandPriority = new JLabel("Priority : "+command.PRIORITY);
        commandName.setHorizontalAlignment(JLabel.CENTER);
        add(commandName);
        add(commandCost);
        add(commandPriority);
        setToolTipText(command.description);
    }

    public void addCommandListener(CommandListener listener){
        commandListener = listener;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        commandListener.action(new CommandSelected(command));

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        setBackground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        setBackground(Color.white);

    }
}
