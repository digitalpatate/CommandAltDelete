package ch.heigvd.thecommandmasters.Scene.Game;

import javax.swing.*;
import java.awt.*;

public class BoardOld extends JPanel {
    private Image bardejov;

    public BoardOld() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = bardejov.getWidth(this);
        int h =  bardejov.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("background.png");
        bardejov = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bardejov, 0, 0, null);
    }}
