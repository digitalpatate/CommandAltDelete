package ch.heigvd.thecommandmasters.Scene.CharacterSelection;

import ch.heigvd.thecommandmasters.Character.EntityClass;
import ch.heigvd.thecommandmasters.Event.ChoseEvent;
import ch.heigvd.thecommandmasters.Event.ChoseListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EntityPanel extends JPanel implements MouseListener {
    EntityClass entityClass;
    ChoseListener choseListener;

    public EntityPanel(EntityClass ec) {
        this.entityClass = ec;
        JPanel data = new JPanel();
        data.setLayout(new GridLayout(2,2));
        data.add(new Label("Health point :" +ec.getHealth()));
        data.add(new Label("Energy point :" +ec.getEnergy()));
        data.add(new Label("Power point :" +ec.getPower()));
        data.add(new Label("Defence point :" +ec.getDefence()));

        add(data);
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

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void addChoseListener(ChoseListener listener){
        choseListener = listener;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(entityClass.getImage(), 0, 100, getWidth()-100, getHeight()-100, null);
    }
}
