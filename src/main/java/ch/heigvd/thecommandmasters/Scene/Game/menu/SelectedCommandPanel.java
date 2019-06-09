package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SelectedCommandPanel extends JPanel {
    LinkedList<Command> commands;
    public SelectedCommandPanel(){

        this.commands = new LinkedList<>();

        setBackground(Color.ORANGE);
    }

    public void addCommandToList(Command c) {
        commands.add(c);
        JLabel commandName = new JLabel(c.name);
        add(commandName);
        this.revalidate();
        this.repaint();
    }



}
