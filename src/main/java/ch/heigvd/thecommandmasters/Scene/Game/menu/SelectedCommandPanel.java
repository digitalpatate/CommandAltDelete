package ch.heigvd.thecommandmasters.Scene.Game.menu;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.state.game.GameContext;
import ch.heigvd.thecommandmasters.state.game.PlayerRoundState;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class SelectedCommandPanel extends JPanel {
    LinkedList<Command> commands;
    public SelectedCommandPanel(){
        setLayout(new GridLayout(3,5,10,10));


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
        commandName.setHorizontalAlignment(JLabel.CENTER);
        Border blackline = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        commandName.setBorder(blackline);

        commandName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                commands.remove(c);
                remove(commandName);

                int playerID = ((PlayerRoundState) GameContext.getInsance().getState()).PLAYER_ID;
                Entity entity;

                if (playerID == 0) {
                    entity = GameContext.getInsance().getGameLogic().getPlayer1();
                } else {
                    entity = GameContext.getInsance().getGameLogic().getPlayer2();
                }

                if (entity != null) {
                    entity.changeEnergy(c.COST);
                }

                revalidate();
                repaint();
            }
        });

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
