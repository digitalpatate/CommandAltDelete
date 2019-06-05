package ch.heigvd.thecommandmasters;

import javax.swing.*;
import ch.heigvd.thecommandmasters.Character.*;

import java.util.LinkedList;

public class Controller {
    JFrame mainWindow;

    //LinkedList<RoleType> roleTypes;
    LinkedList<Entity> entities;


    void load(){
        //entities = Entity.load();
        //roleTyoes = RoleType.load();
    }

    public Controller() {
        load();

        // Select RoleType

        //Select Entity


    }

    public static void main(String[] args) {
        new Controller();
    }
}