package ch.heigvd.thecommandmasters.Scene.Game.simulation;

import ch.heigvd.thecommandmasters.Character.Entity;

import java.awt.*;

public class EntityNode implements Node {

    private Point position;

    private Image image;
    private LifeBarNode lifeBar;

    public EntityNode(Entity entity, Point position, Dimension dimension) {
        this.position = position;
        this.image = entity.ENTITY_CLASS.getImage()
                .getScaledInstance(dimension.width, dimension.height, 1);
        lifeBar = new LifeBarNode(entity.getMaxHealth(),
                new Dimension(dimension.width, 20),
                new Point(position.x, position.y - 40));
        updateHealth(entity.getHealth());
    }

    public void updateHealth(int amount) {
        lifeBar.setHealth(amount);
    }

    public void updatePosition(Point position) {
        this.position = position;
        lifeBar.setPosition(new Point(position.x, position.y - 40));
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, position.x, position.y, null);
        lifeBar.draw(graphics2D);
    }
}
