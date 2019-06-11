package ch.heigvd.thecommandmasters.Scene.Game.simulation;

import ch.heigvd.thecommandmasters.Application;
import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Game.GameLogic;
import ch.heigvd.thecommandmasters.Scene.Game.EndGamePanel;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.displayer.Displayer;
import ch.heigvd.thecommandmasters.displayer.DisplayerManager;
import ch.heigvd.thecommandmasters.state.game.GameContext;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SimulationPanel extends JPanel implements Displayer {

    private GameContext gameContext;
    private GameLogic gameLogic;

    private static final int FPS = 30;
    private static final double FRAME_PER_ACTION = 15;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int SPACE = 10;

    private final int TILE_WIDTH;

    EntityNode[] players;
    LinkedList<Node> nodes;

    private Image image;

    public SimulationPanel() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        gameContext = GameContext.getInsance();
        gameLogic = gameContext.getGameLogic();

        TILE_WIDTH = WIDTH / gameContext.getGameScene().MAP_SIZE;
        System.out.println(TILE_WIDTH);

        nodes = new LinkedList<>();

        for (int i = 0; i < gameContext.getGameScene().MAP_SIZE; ++i) {
            nodes.add(new ShapeNode(new Rectangle(
                    TILE_WIDTH * i + SPACE / 2, HEIGHT - 50,
                    TILE_WIDTH - SPACE, 25
            )));
        }

        Entity[] entities = new Entity[] {gameLogic.getPlayer1(), gameLogic.getPlayer2()};
        players = new EntityNode[entities.length];
        for (int i = 0; i < entities.length; ++i) {
            players[i] = new EntityNode(
                    entities[i],
                    getEntityPosition(entities[i].getPosition()),
                    getEntityImageSize()
            );
        }
    }

    public void playSimulation(Command[] p1Commands, Command[] p2Commands) {

        DisplayerManager.setDisplayer(this);

        gameLogic.setupRound(p1Commands, p2Commands);
        double actionTimer = 0;

        while (true) {

            ++actionTimer;

            if (actionTimer >= FRAME_PER_ACTION) {

                if (gameLogic.hasWinner()) {
                    System.out.println("Show winner!");
                    break;
                }

                if (gameLogic.hasFinished()) {
                    System.out.println("Start next round");
                    break;
                }

                gameLogic.nextAction();
                actionTimer = 0;
            }

            draw();

            try {
                Thread.sleep(1000 / FPS);
            } catch (InterruptedException e) {
                System.out.println("Can't sleep.");
            }
        }

        gameLogic.endRound();
        GameContext.getInsance().resetSelectedCommands();

        if (gameLogic.hasWinner()) {

            gameContext.getGameScene().removeAll();
            gameContext.getGameScene().add(new EndGamePanel());
            gameContext.getGameScene().revalidate();
            gameContext.getGameScene().repaint();

        } else {
            gameContext.setState(gameContext.getState().getNextState());
        }
    }

    private void draw() {
        // Draw nodes
        image = createImage(WIDTH, HEIGHT);


        for (Node node : nodes) {
            node.draw((Graphics2D) image.getGraphics());
        }

        for (Node node : players) {
            node.draw((Graphics2D) image.getGraphics());
        }

        Application.APP.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void showDamage(Entity entity, int amount) {
        players[entity.getId()].updateHealth(entity.getHealth());
    }

    @Override
    public void showHeal(Entity entity, int amount) {
        players[entity.getId()].updateHealth(entity.getHealth());
    }

    @Override
    public void showEnergy(Entity entity, int amount) {}

    @Override
    public void showMovement(Entity entity, int from, int to) {
        players[entity.getId()].updatePosition(getEntityPosition(to));
    }

    private Dimension getEntityImageSize() {
        return new Dimension(TILE_WIDTH, TILE_WIDTH * 860 / 520);
    }

    private Point getEntityPosition(int position) {
        return new Point(TILE_WIDTH * position + SPACE / 2, HEIGHT - 50 - getEntityImageSize().height);
    }
}
