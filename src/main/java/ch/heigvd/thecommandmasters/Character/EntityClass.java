package ch.heigvd.thecommandmasters.Character;

import ch.heigvd.thecommandmasters.Game.Map;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.command.MacroCommand;
import ch.heigvd.thecommandmasters.command.UndoLastAction;
import ch.heigvd.thecommandmasters.command.action.MovementAction;
import ch.heigvd.thecommandmasters.command.action.attack.AttackAction;
import ch.heigvd.thecommandmasters.command.action.attack.AttackModifier;
import ch.heigvd.thecommandmasters.command.action.attack.DefensibleAttackAction;
import ch.heigvd.thecommandmasters.command.action.boost.AttackBoostAction;
import ch.heigvd.thecommandmasters.command.action.boost.DefenseBoostAction;
import ch.heigvd.thecommandmasters.command.action.heal.HealAction;
import ch.heigvd.thecommandmasters.command.action.heal.MaxPercentageHealAction;
import ch.heigvd.thecommandmasters.command.action.heal.PercentageHealAction;
import ch.heigvd.thecommandmasters.command.action.stateffect.HealthEffectAction;
import ch.heigvd.thecommandmasters.command.invoker.CommandInvoker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntityClass {

    private JSONObject jsonObject;
    private JSONArray jsonGenericCommand;
    private Image image;

    /**
     * Constructor, Opens the EntityClass file with a JSONObject
     *
     * @param fileClass The EntityClass file
     */

    /**
     * Constructor, Opens the EntityClass file with a JSONObject
     *
     * @param fileClass          The EntityClass file
     * @param fileGenericCommand The Generics Command file
     */
    public EntityClass(File fileClass, File fileGenericCommand) {
        JSONParser parser = new JSONParser();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(fileClass));
            jsonGenericCommand = (JSONArray) parser.parse(new FileReader(fileGenericCommand));
            image = new ImageIcon((String) jsonObject.get("image")).getImage();

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a character from the class information
     *
     * @return The new character
     */
    public Entity createEntity() {
        return new Entity(this);
    }

    /**
     * indicates the maximum life that the character will
     *
     * @return The maximum life
     */
    public int getHealth() {
        return Integer.parseInt(jsonObject.get("health").toString());
    }

    /**
     * indicates the power the character will have
     *
     * @return the power
     */
    public int getPower() {
        return Integer.parseInt(jsonObject.get("power").toString());
    }

    /**
     * indicates the defence that the character will have
     *
     * @return The defence
     */
    public int getDefence() {
        return Integer.parseInt(jsonObject.get("defence").toString());
    }

    /**
     * indicates the maximum energy that the character will
     *
     * @return The maximum energy
     */
    public int getEnergy() {
        return Integer.parseInt(jsonObject.get("energy").toString());
    }

    /**
     * Shows the image corresponding to the character's class
     *
     * @return The image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Creates all commands that can be used by this character
     *
     * @param yourSelf the entity create by this class
     * @param opponent the opponent entity
     * @param map      the game map
     * @param invoker
     * @return the list of usable commands
     */
    public List<Command> createCommands(Entity yourSelf, Entity opponent, Map map, CommandInvoker invoker) {
        List<Command> commands = new ArrayList<>();

        JSONArray techniques = (JSONArray) jsonObject.get("technique");
        commands.addAll(createClassSpecificCommand(yourSelf, opponent, map, invoker, techniques));

        commands.addAll(createClassSpecificCommand(yourSelf, opponent, map, invoker, jsonGenericCommand));

        return commands;
    }

    /**
     * Creates all commands that can be used by this character from a JsonObject
     *
     * @param yourSelf  the entity create by this class
     * @param opponent  the opponent entity
     * @param map       the game map
     * @param invoker
     * @param jsonArray Json that contains the command information
     * @return the list of usable commands
     */
    private List<Command> createClassSpecificCommand(Entity yourSelf, Entity opponent, Map map,
                                                     CommandInvoker invoker, JSONArray jsonArray) {
        List<Command> commands = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); ++i) {
            JSONObject technique = (JSONObject) jsonArray.get(i);
            JSONArray actions = (JSONArray) technique.get("actions");

            List<Command> techniqueActionList = new ArrayList<>();
            for (int j = 0; j < actions.size(); ++j) {
                techniqueActionList.add(createCommand(yourSelf, opponent, map, invoker, (JSONObject) actions.get(j)));
            }

            int priority = Integer.parseInt(technique.get("priority").toString());
            int cost = (int) (long) technique.get("cost");

            Command command = new MacroCommand(priority, cost, techniqueActionList);
            command.name = (String) technique.get("name");
            command.description = (String) technique.get("description");

            commands.add(command);
        }

        return commands;
    }

    /**
     * create a command depending on its type
     *
     * @param yourSelf the entity create by this class
     * @param opponent the opponent entity
     * @param map      the game map
     * @param invoker
     * @param action   command information
     * @return the command creates
     */
    private Command createCommand(Entity yourSelf, Entity opponent, Map map, CommandInvoker invoker, JSONObject action) {
        switch ((String) action.get("type")) {
            case "ATTACK":
                return createCommandAttack(yourSelf, opponent, map, action);
            case "HEAL":
                return createCommandHeal(yourSelf, action);
            case "MOVEMENT":
                return createCommandMovement((boolean) action.get("targetSelf") ? yourSelf : opponent, map, action);
            case "BOOST":
                return createCommandBoost((boolean) action.get("targetSelf") ? yourSelf : opponent, action);
            case "STAT_EFFECT":
                return createCommandStateffect((boolean) action.get("targetSelf") ? yourSelf : opponent, action);
            case "UNDO":
                return new UndoLastAction((boolean) action.get("targetSelf") ? yourSelf : opponent, invoker);
            default:
                return null;
        }
    }

    /**
     * create an attack command
     *
     * @param yourSelf the entity create by this class
     * @param opponent the opponent entity
     * @param map      the game map
     * @param action   command information
     * @return the command creates
     */
    private Command createCommandAttack(Entity yourSelf, Entity opponent, Map map, JSONObject action) {

        JSONArray modifiers = (JSONArray) action.get("modifiers");
        AttackModifier[] attackModifierList = new AttackModifier[modifiers.size() + 1];

        for (int i = 0; i < modifiers.size(); ++i) {
            int distance = Integer.parseInt(((JSONArray) modifiers.get(i)).get(0).toString());
            int percentage = Integer.parseInt(((JSONArray) modifiers.get(i)).get(1).toString());
            attackModifierList[i] = new AttackModifier(distance, percentage);
        }

        int defaut = Integer.parseInt(action.get("default").toString());
        attackModifierList[modifiers.size()] = new AttackModifier(map.getMapSize(), defaut);

        switch (Integer.parseInt(action.get("attackType").toString())) {
            case 0:
                return new AttackAction(yourSelf, opponent, defaut, attackModifierList);
            case 1:
                return new DefensibleAttackAction(yourSelf, opponent, defaut, attackModifierList);
            default:
                return null;
        }
    }

    /**
     * create an boost command
     *
     * @param e      the affected entity
     * @param action command information
     * @return the command creates
     */
    private Command createCommandBoost(Entity e, JSONObject action) {

        int value = Integer.parseInt(action.get("value").toString());
        int duration = Integer.parseInt(action.get("duration").toString());

        switch (Integer.parseInt(action.get("boostType").toString())) {
            case 0:
                return new AttackBoostAction(e, value, duration);
            case 1:
                return new DefenseBoostAction(e, value, duration);
            default:
                return null;
        }
    }

    /**
     * create an heal command
     *
     * @param e      the affected entity
     * @param action command information
     * @return the command creates
     */
    private Command createCommandHeal(Entity e, JSONObject action) {
        int value = Integer.parseInt(action.get("value").toString());

        switch (Integer.parseInt(action.get("healType").toString())) {
            case 0:
                return new HealAction(e, value);
            case 1:
                return new MaxPercentageHealAction(e, value);
            case 2:
                return new PercentageHealAction(e, value);
            default:
                return null;
        }
    }

    /**
     * create an state effect command
     *
     * @param e      the affected entity
     * @param action command information
     * @return the command creates
     */
    private Command createCommandStateffect(Entity e, JSONObject action) {
        int value = Integer.parseInt(action.get("value").toString());
        int duration = Integer.parseInt(action.get("duration").toString());

        switch (Integer.parseInt(action.get("statEffectType").toString())) {
            case 0:
                return new HealthEffectAction(e, value, duration);
            default:
                return null;
        }
    }

    /**
     * create an movement command
     *
     * @param e      the affected entity
     * @param map    the game map
     * @param action command information
     * @return the command creates
     */
    private Command createCommandMovement(Entity e, Map map, JSONObject action) {
        int value = Integer.parseInt(action.get("value").toString());

        return new MovementAction(e, map, value);
    }

    @Override
    public String toString() {
        return jsonObject.get("class").toString();
    }
}
