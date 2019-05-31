package ch.heigvd.thecommandmasters.Character;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EntityClass implements Displayer{

    private JSONObject jsonObject;

    public EntityClass(File fileClass){

        JSONParser parser = new JSONParser();

        try {
            jsonObject = (JSONObject)parser.parse(new FileReader(fileClass));

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entity createEntity(){
        return new Entity(getHealth(), getEnergy(), getPower(), getShield(), this.toString());
    }

    public int getHealth(){
        return Integer.parseInt((String)jsonObject.get("health"));
    }

    public int getPower(){
        return Integer.parseInt((String)jsonObject.get("power"));
    }

    public int getShield(){
        return Integer.parseInt((String)jsonObject.get("shield"));
    }

    public int getEnergy() { return Integer.parseInt((String)jsonObject.get("energy")); }

    @Override
    public String toString(){
        return (String)jsonObject.get("class");
    }

    @Override
    public JPanel getPanel() {
        return null;
    }
}
