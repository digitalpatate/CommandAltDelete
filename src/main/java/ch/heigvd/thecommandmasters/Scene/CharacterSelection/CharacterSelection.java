package ch.heigvd.thecommandmasters.Scene.CharacterSelection;

import ch.heigvd.thecommandmasters.Character.EntityClass;
import ch.heigvd.thecommandmasters.Event.ChoseEvent;
import ch.heigvd.thecommandmasters.Event.ChoseListener;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;



public class CharacterSelection extends JPanel{
    LinkedList<EntityClass> characters;
    ChoseListener listener;
    public CharacterSelection(int width, int heigth){
        setPreferredSize(new Dimension(width,heigth));
        load();
        this.setLayout(new GridLayout(0,characters.size()));
        setBackground(Color.BLACK);
        for(EntityClass e : characters){
            EntityPanel panel = new EntityPanel(e);
            add(panel);
            panel.addChoseListener(e1 -> listener.action(new ChoseEvent(e1.getChosenOne())));
        }
    }

    private void load() {
        String directory = ".\\data";
        this.characters = new LinkedList<>();
        File repertoire = new File(directory);
        String liste[] = repertoire.list((x,y) -> y.endsWith(".JSON") ? true : false);

        if(liste != null){
            for(String s : liste)
                characters.add(new EntityClass(new File(directory + "\\" + s)));
        }
    }

    public void addChoseListener(ChoseListener listener){
        this.listener = listener;
    }

}
