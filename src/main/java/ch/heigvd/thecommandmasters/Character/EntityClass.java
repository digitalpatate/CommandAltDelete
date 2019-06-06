package ch.heigvd.thecommandmasters.Character;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EntityClass{

    private JSONObject jsonObject;
    private Image image;

    public EntityClass(File fileClass) {

        JSONParser parser = new JSONParser();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(fileClass));
            image = new ImageIcon((String) jsonObject.get("image")).getImage();

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entity createEntity() {
        return new Entity(getHealth(), getEnergy(), getPower(), getDefence(), this.toString());
    }

    public int getHealth() {
        return Integer.parseInt(jsonObject.get("health").toString());
    }

    public int getPower() {
        return Integer.parseInt(jsonObject.get("power").toString());
    }

    public int getDefence() {
        return Integer.parseInt(jsonObject.get("Defence").toString());
    }

    public int getEnergy() {
        return Integer.parseInt(jsonObject.get("energy").toString());
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return jsonObject.get("health").toString();
    }
}
