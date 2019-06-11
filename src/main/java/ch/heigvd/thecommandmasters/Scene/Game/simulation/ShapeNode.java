package ch.heigvd.thecommandmasters.Scene.Game.simulation;

import java.awt.*;

class ShapeNode implements Node {

    private Shape shape;

    ShapeNode(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fill(shape);
    }
}
