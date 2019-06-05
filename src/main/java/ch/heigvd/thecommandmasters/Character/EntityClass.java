package ch.heigvd.thecommandmasters.Character;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
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
        return new Entity(getHealth(), getEnergy(), getPower(), getDefence(), this.toString());
    }

    public int getHealth(){
        return (int)jsonObject.get("health");
    }

    public int getPower(){
        return (int)jsonObject.get("power");
    }

    public int getDefence(){
        return (int)jsonObject.get("Defence");
    }

    public int getEnergy() { return (int)jsonObject.get("energy"); }

    @Override
    public String toString(){
        return (String)jsonObject.get("class");
    }

    @Override
    public JLabel getImage() {
        JLabel label = null;

        try {
            BufferedImage image = ImageIO.read(new File((String)jsonObject.get("image")));
            label = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return label;
    }
}
