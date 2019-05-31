package ch.heigvd.thecommandmasters.Scene.CharacterSelection;

import ch.heigvd.thecommandmasters.Character.Entity;
import ch.heigvd.thecommandmasters.Event.ChoseEvent;
import ch.heigvd.thecommandmasters.Event.ChoseListener;

import javax.swing.*;

import java.awt.*;
import java.util.LinkedList;



public class CharacterSelection extends JPanel{
    LinkedList<Entity> characters;
    ChoseListener listener;
    public CharacterSelection(int width, int heigth){
        setPreferredSize(new Dimension(width,heigth));
        load();
        this.setLayout(new GridLayout(0,characters.size()));
        setBackground(Color.BLACK);
        for(Entity e : characters){
            EntityPanel panel = new EntityPanel(e);
            add(panel);
            panel.addChoseListener(e1 -> listener.action(new ChoseEvent(e1.getChosenOne())));
        }
    }

    private void load() {
        this.characters = new LinkedList<>();
        characters.add(new Entity("Monsieur Patate", 0));
        characters.add(new Entity("Madame Patate", 1));
        characters.add(new Entity("Fils Patate", 2));
    }

    public void addChoseListener(ChoseListener listener){
        this.listener = listener;
    }

}
