package ch.heigvd.thecommandmasters.Scene.Game.simulation;

import java.awt.*;

public class LifeBarNode implements Node {

    private int max;
    private int amount;
    private Dimension size;
    private Point position;

    public LifeBarNode(int max, Dimension size, Point position) {
        this.max = max;
        this.amount = max;
        this.size = size;
        this.position = position;
    }

    public void setHealth(int amount) {
        this.amount = amount;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        graphics2D.drawRect(position.x, position.y, size.width, size.height);
        graphics2D.fillRect(position.x, position.y, amount * size.width / max, size.height);
    }
}
