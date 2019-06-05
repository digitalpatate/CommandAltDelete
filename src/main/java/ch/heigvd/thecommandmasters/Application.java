package ch.heigvd.thecommandmasters;

import ch.heigvd.thecommandmasters.Scene.CharacterSelection.CharacterSelection;
import ch.heigvd.thecommandmasters.Scene.Game.GameScene;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class Application extends JFrame implements EventListener {


    Dimension dimension;
    JPanel contentPanel;


    private Application(int windowsWidth, int windowsHeigth) {
        this.dimension  = new Dimension(windowsWidth,windowsHeigth);
        initUI();


        CharacterSelection panel = new CharacterSelection(dimension);
        contentPanel.add(panel);
        panel.addChoseListener(e1 -> {
            System.out.println(e1.getChosenOne());
            GameScene gameScene = new GameScene(dimension);

            this.contentPanel.remove(panel);
            this.contentPanel.add(gameScene);
            this.contentPanel.revalidate();
            this.contentPanel.repaint();
        });
    }
    private void initUI() {

        setTitle("CommandMaster");
        setSize(dimension);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setResizable(false);

        this.contentPanel = new JPanel();
        contentPanel.setPreferredSize(dimension);
        add(contentPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application frame = new Application(1280,720);
            frame.setVisible(true);
            frame.setLayout(null);
        });
    }
}
