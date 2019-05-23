package ch.heigvd.thecommandmasters;

import javax.swing.*;
import java.awt.*;

public class CommandMaster extends JFrame {
    public CommandMaster() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(1600, 900);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String...args){
        EventQueue.invokeLater(() -> {
            CommandMaster ex = new CommandMaster();
            ex.setVisible(true);
        });
    }
}
