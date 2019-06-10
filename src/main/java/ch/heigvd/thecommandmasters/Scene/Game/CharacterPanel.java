package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Character.Entity;

import javax.swing.*;

public class CharacterPanel extends JPanel {

    Entity entity=null;

    public CharacterPanel() {
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {

        this.entity = entity;
        this.draw();

    }

    public void draw() {
        removeAll();
        if(entity == null){
            revalidate();
            repaint();
            return;
        }
        JLabel hp = new JLabel("Health : "+ entity.getHealth());
        JLabel energy = new JLabel("Energy : "+ entity.getEnergy());

        add(hp);
        add(energy);
        revalidate();
        repaint();
    }

    public void removeEntity() {

        this.entity = null;
        this.draw();


    }
}
