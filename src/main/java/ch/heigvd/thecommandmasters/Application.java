package ch.heigvd.thecommandmasters;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    int windowsWidth;
    int windowsHeigth;

    public Application(int windowsWidth,int windowsHeigth) {

        this.windowsHeigth =windowsHeigth;
        this.windowsWidth=windowsWidth;
        initUI();
    }
    private void initUI() {

        add(new CharacterSelection(windowsWidth,windowsHeigth));

        setSize(windowsWidth, windowsHeigth);

        setTitle("CommandMaster");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application frame = new Application(1600, 900);
            frame.setVisible(true);
        });
    }
}
