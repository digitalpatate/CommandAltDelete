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
        return new Entity(getLife(), getPower(), getShield());
    }

    public int getLife(){
        return Integer.parseInt((String)jsonObject.get("life"));
    }

    public int getPower(){
        return Integer.parseInt((String)jsonObject.get("power"));
    }

    public int getShield(){
        return Integer.parseInt((String)jsonObject.get("shield"));
    }

    @Override
    public String toString(){
        return (String)jsonObject.get("class");
    }

    @Override
    public JPanel getPanel() {
        return null;
    }
}
