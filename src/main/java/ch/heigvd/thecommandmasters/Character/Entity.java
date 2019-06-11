package ch.heigvd.thecommandmasters.Character;

import ch.heigvd.thecommandmasters.Stat.*;
import ch.heigvd.thecommandmasters.command.Command;
import ch.heigvd.thecommandmasters.displayer.DisplayerManager;

import java.util.List;

public class Entity {

    private Stats health;
    private Stats energy;
    private Feature power;
    private Feature defense;
    private String name;
    private int id;
    private int position;
    private List<Command> commands;
    public final EntityClass ENTITY_CLASS;

    /**
     * Constructor
     *
     * @param health  Maximum life of the character
     * @param energy  Maximum Energy of the character
     * @param power   Character's power
     * @param Defense Defending the character
     * @param name    Character's name
     */
    public Entity(int health, int energy, int power, int Defense, String name, EntityClass entityClass) {
        this.health = new Stats(health, "Health");
        this.energy = new Stats(energy, "Energy");
        this.power = new Feature(power, "Power");
        this.defense = new Feature(Defense, "Defense");
        this.name = name;
        this.ENTITY_CLASS = entityClass;

        this.id = -1;
        this.position = 0;
        this.commands = null;
    }

    public Entity(EntityClass entityClass) {
        this(
                entityClass.getHealth(),
                entityClass.getEnergy(),
                entityClass.getPower(),
                entityClass.getDefence(),
                entityClass.toString(),
                entityClass
        );
    }

    /**
     * Indicates the name of the character.
     *
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * indicates the character ID
     *
     * @return Character ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id New id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * indicates the position of the character
     *
     * @return The position of the character
     */
    public int getPosition() {
        return position;
    }

    /**
     * Changes the position of the character
     *
     * @param position The new position of the character
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Gets the command list of the entity.
     *
     * @return Entity's commands.
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Sets the commands of the entity.
     *
     * @param commands New commands.
     */
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    /**
     * Move the position of the character
     *
     * @param amount the number of boxes to advance the character
     */
    public void move(int amount) {

        int current = position;
        position += amount;

        if (DisplayerManager.hasDisplayer()) {
            DisplayerManager.getDisplayer().showMovement(this, current, position);
        }
    }

    /**
     * Heals the entity.
     *
     * @param amount The amount to heal. Should be positive.
     * @return True if the entity has been healed. False if amount was negative.
     */
    public boolean heal(int amount) {
        if (amount < 0) {
            return false;
        }

        health.changeStat(amount);

        if (DisplayerManager.hasDisplayer()) {
            DisplayerManager.getDisplayer().showHeal(this, amount);
        }

        return true;
    }

    /**
     * Makes the entity receive damage
     *
     * @param amount The amount of damage to receive. Should be positive.
     * @return True if the entity has been damaged. False if amount was negative.
     */
    public boolean damage(int amount) {
        if (amount < 0) {
            return false;
        }

        health.changeStat(-amount);

        if (DisplayerManager.hasDisplayer()) {
            DisplayerManager.getDisplayer().showDamage(this, amount);
        }

        return true;
    }

    public void changeEnergy(int amount) {
        energy.changeStat(amount);

        if (DisplayerManager.hasDisplayer()) {
            DisplayerManager.getDisplayer().showEnergy(this, amount);
        }
    }

    public void fillEnergy() {
        changeEnergy(energy.MAX);
    }

    /**
     * Updates the stat effects attach to the health.
     */
    public void updateHealthEffects() {

        int effectsValue = health.updateEffects();

        if (effectsValue < 0) {
            damage(-effectsValue);
        } else if (effectsValue > 0) {
            heal(effectsValue);
        }
    }

    /**
     * Adds a stat effect to the health.
     *
     * @param statEffect New stat effect.
     */
    public void addHealthEffect(StatEffect statEffect) {
        health.addEffect(statEffect);
    }

    /**
     * Removes a stat effect from the health.
     *
     * @param statEffect Stats effect to remove.
     */
    public void removeHealthEffect(StatEffect statEffect) {
        health.removeEffect(statEffect);
    }

    /**
     * Updates the boosts attached to the power.
     */
    public void updatePowerBoosts() {
        power.updateBoosts();
    }

    /**
     * Adds a boost to the power.
     *
     * @param boost New boost.
     */
    public void addPowerBoost(Boost boost) {
        power.addBoost(boost);
    }

    /**
     * Removes a boost from the power.
     *
     * @param boost Boost to remove.
     */
    public void removePowerBoost(Boost boost) {
        power.removeBoost(boost);
    }

    /**
     * Updates the boosts attached to the defense.
     */
    public void updateDefenseBoosts() {
        defense.updateBoosts();
    }

    /**
     * Adds a boost to the defense.
     *
     * @param boost New boost.
     */
    public void addDefenseBoost(Boost boost) {
        defense.addBoost(boost);
    }

    /**
     * Removes a boost from the power.
     *
     * @param boost Boost to remove.
     */
    public void removeDefenseBoost(Boost boost) {
        defense.removeBoost(boost);
    }

    /**
     * indicates the current life of the character
     *
     * @return the current life
     */
    public int getHealth() {
        return health.getValue();
    }

    /**
     * indicates the maximum life of the character
     *
     * @return the maximum life
     */
    public int getMaxHealth() {
        return health.MAX;
    }

    /**
     * Indicates the current energy of the character
     *
     * @return the current energy
     */
    public int getEnergy() {
        return energy.getValue();
    }

    /**
     * indicates the maximum energy of the character
     *
     * @return the maximum energy
     */
    public int getMaxEnergy() {
        return energy.MAX;
    }

    /**
     * indicates the current defense of the character
     *
     * @return the current defense
     */
    public int getDefense() {
        return defense.getValue();
    }

    /**
     * indicates the current power of the character
     *
     * @return the current power
     */
    public int getPower() {
        return power.getValue();
    }
}