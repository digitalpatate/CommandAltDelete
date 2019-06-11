package ch.heigvd.thecommandmasters.Scene.Game;

import ch.heigvd.thecommandmasters.Character.Entity;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CharacterPanel extends JPanel {

    Entity entity=null;
    Image image;

    public CharacterPanel() {
       Border blackline = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        setBorder(blackline);
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {

        this.entity = entity;
        this.image = entity.ENTITY_CLASS.getImage();

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      g.drawImage(image, 25, 75, 52, 86, null);
    }
}
