package ch.heigvd.thecommandmasters;

import ch.heigvd.thecommandmasters.state.CharacterSelectionState;
import ch.heigvd.thecommandmasters.state.Context;
import ch.heigvd.thecommandmasters.state.GameState;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.EventListener;

public class Application extends JFrame implements EventListener {


    Dimension dimension;
    JPanel contentPanel;


    CharacterSelectionState selectPlayer1State;
    CharacterSelectionState selectPlayer2State;

    GameState gameState;

    Context context;


    private Application(int windowsWidth, int windowsHeigth) throws InterruptedException, InvocationTargetException {
        this.dimension  = new Dimension(windowsWidth,windowsHeigth);
        initUI();

        this.context = new Context(contentPanel);
        gameState = new GameState();

        selectPlayer2State = new CharacterSelectionState(gameState);
        selectPlayer1State = new CharacterSelectionState(selectPlayer2State);
        context.setState(selectPlayer1State);
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
            Application frame = null;
            try {
                frame = new Application(1280,720);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            frame.setVisible(true);
            frame.setLayout(null);
        });
    }
}
