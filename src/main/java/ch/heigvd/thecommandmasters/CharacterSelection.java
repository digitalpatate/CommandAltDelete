package ch.heigvd.thecommandmasters;

import javax.swing.*;

import java.awt.*;
import java.util.LinkedList;

public class CharacterSelection extends JPanel {
    LinkedList<Entity> characters;
    CharacterSelection(int width,int heigth){
        load();
        int panelSize= width/characters.size();
        for(Entity e : characters){
            add(new EntityPanel(e,panelSize,heigth));
        }
    }

    private void load() {
        this.characters = new LinkedList<>();
    }

}
