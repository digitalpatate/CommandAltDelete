package ch.heigvd.thecommandmasters.Scene.CharacterSelection;

import ch.heigvd.thecommandmasters.Entity;
import ch.heigvd.thecommandmasters.Event.ChoseEvent;
import ch.heigvd.thecommandmasters.Event.ChoseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EntityPanel extends JPanel implements MouseListener {
    Entity entity;
    ChoseListener choseListener;

    public EntityPanel(Entity e) {
        this.entity = e;
        setBackground(Color.BLUE);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        choseListener.action(new ChoseEvent(entity));
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        setBackground(Color.RED);

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        setBackground(Color.BLUE);
    }

    public void addChoseListener(ChoseListener listener){
        choseListener = listener;
    }
}
