package ch.heigvd.thecommandmasters.state;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Character.EntityClass;

import javax.swing.*;
import java.util.LinkedList;

public class Context {
    private State state;
    private JPanel contentPanel;

    LinkedList<EntityClass> players;

    public Context(JPanel contentPanel){
        players = new LinkedList<>();
        this.contentPanel = contentPanel;
        state = null;
    }

    public void setState(State state){
        this.state = state;
        contentPanel.removeAll();
        state.doAction(this);
    }

    public State getState(){
        return state;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public LinkedList<EntityClass> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<EntityClass> players) {
        this.players = players;
    }
}
