package ch.heigvd.thecommandmasters;

import ch.heigvd.thecommandmasters.Scene.CharacterSelection.CharacterSelection;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class Application extends JFrame implements EventListener {

    int windowsWidth;
    int windowsHeigth;


    private Application(int windowsWidth, int windowsHeigth) {

        this.windowsHeigth =windowsHeigth;
        this.windowsWidth=windowsWidth;
        initUI();
        CharacterSelection panel = new CharacterSelection(windowsWidth,windowsHeigth);
        panel.addChoseListener(e1 -> System.out.println(e1.getChosenOne()));

        setPanel(panel);

    }
    private void initUI() {

        setTitle("CommandMaster");
        setSize(windowsWidth, windowsHeigth);
        setLayout(new FlowLayout(0,0,0));
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void setPanel(JPanel panel){
        add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application frame = new Application(1280,720);
            frame.setVisible(true);
            frame.setLayout(null);
        });
    }
}
