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
    public void reset(){
        removeAll();
        commands.clear();
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
        commands.add(c);
        JLabel commandName = new JLabel(c.name);
        add(commandName);
        this.revalidate();
        this.repaint();
    }

    public LinkedList<Command> getCommands() {
        System.out.println(commands);
        return commands;
    }

    public void setCommands(LinkedList<Command> commands) {
        this.commands = commands;
    }
}
