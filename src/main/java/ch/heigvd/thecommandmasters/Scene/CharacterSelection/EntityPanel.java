package ch.heigvd.thecommandmasters.Scene.CharacterSelection;

import ch.heigvd.thecommandmasters.Character.EntityClass;
import ch.heigvd.thecommandmasters.Event.ChoseEvent;
import ch.heigvd.thecommandmasters.Event.ChoseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EntityPanel extends JPanel implements MouseListener {
    EntityClass entityClass;
    ChoseListener choseListener;

    public EntityPanel(EntityClass ec) {
        this.entityClass = ec;
        setBackground(Color.BLUE);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        choseListener.action(new ChoseEvent(entityClass));
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(entityClass.getImage(), 0, 0, getWidth()-40, getHeight()-40, null);
    }
}
