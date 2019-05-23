package ch.heigvd.thecommandmasters;

import javax.swing.*;
import java.awt.*;

public class EntityPanel extends JPanel {
    Entity entity;
    public EntityPanel(Entity e, int panelWidth,int panelHeigth) {
        this.entity = e;
        setSize(panelWidth,panelHeigth);
        setBackground(Color.BLUE);
    }


}
