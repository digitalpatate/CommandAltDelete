package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.command.Command;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SelectedCommandPanel extends JPanel {
    LinkedList<Command> commands;
    public SelectedCommandPanel(){
        setLayout(new GridLayout(10,1));


        this.commands = new LinkedList<>();
    }
    public void reset(){
        System.out.println("selectedCommandPanel reset");
        commands.clear();
        removeAll();
        revalidate();
        repaint();
    }
    public void update(){
        removeAll();

        for(Command c : commands){
            JLabel commandName = new JLabel(c.name);
            add(commandName);
        }
        revalidate();
        repaint();
    }
    public void addCommandToList(Command c) {
        System.out.println("Add command" +c.name);
        commands.add(c);
        JLabel commandName = new JLabel(c.name);
        add(commandName);
        this.revalidate();
        this.repaint();
    }

    public LinkedList<Command> getCommands() {
        return commands;
    }

    public void setCommands(LinkedList<Command> commands) {
        this.commands = commands;
    }
}
