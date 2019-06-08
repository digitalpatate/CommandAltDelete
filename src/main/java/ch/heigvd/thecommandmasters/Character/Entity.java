package ch.heigvd.thecommandmasters.Character;

import ch.heigvd.thecommandmasters.Stat.*;
import java.util.LinkedList;

public class Entity {

    private int id;
    private String name;
    private int position;
    private Stats health;
    private Stats energy;
    private Feature power;
    private Feature defense;
    private LinkedList<Boost> boostAttack;
    private LinkedList<Boost> boostDefense;

    /**
     * Constructeur
     * @param health Maximum life of the character
     * @param energy Maximum Energy of the character
     * @param power Character's power
     * @param Defense Defending the character
     * @param name Character's name
     */
    public Entity(int health, int energy, int power, int Defense, String name) {
        this.health = new Stats(health, "Health");
        this.energy = new Stats(energy, "Energy");
        this.power = new Feature(power, "Power");
        this.defense = new Feature(Defense, "Defense");
        this.name = name;
        boostAttack = new LinkedList<>();
        boostDefense = new LinkedList<>();

        this.position = 0;
        this.id = -1;
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
     * indicates the position of the character
     *
     * @return The position of the character
     */
    public int getPosition() {
        return position;
    }

    /**
     * indicates the name of the character
     *
     * @return The name of the character
     */
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
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
     * Move the position of the character
     *
     * @param amount the number of boxes to advance the character
     */
    public void move(int amount) {
        position += amount;
    }

    /**
     * Heals the entity.
     * @param amount The amount to heal. Should be positive.
     * @return True if the entity has been healed. False if amount was negative.
     */
    public boolean heal(int amount) {
        if (amount <= 0)  { return false; }

        health.changeStat(amount);
        return true;
    }

    /**
     * Makes the entity receive damage
     * @param amount The amount of damage to receive. Should be positive.
     * @return True if the entity has been damaged. False if amount was negative.
     */
    public boolean damage(int amount) {
        if (amount <= 0) { return false; }

        health.changeStat(-amount);
        return true;
    }

//    public int attack() {
//        int increaseDamage = 0;
//        for (Boost b : boostAttack) {
//            increaseDamage += b.getValue();
//            b.reduceDuration();
//        }
//        return power.getValue() + increaseDamage;
//    }

//    private void update() {
//        Iterator itDefense = boostDefense.iterator();
//        while (itDefense.hasNext()) {
//            Boost b = ((Boost) itDefense.next());
//            if (b.getDuration() == 0) {
//                itDefense.remove();
//            }
//        }
//
//        Iterator itAttack = boostAttack.iterator();
//        while (itAttack.hasNext()) {
//            Boost b = ((Boost) itAttack.next());
//            if (b.getDuration() == 0) {
//                itAttack.remove();
//            }
//        }
//
//        updateHealthEffects();
//    }

    /**
     * Updates the stat effects attach to the health.
     */
    public void updateHealthEffects() {
        health.updateEffects();
    }

    /**
     * Adds a stat effect to the health.
     * @param statEffect New stat effect.
     */
    public void addHealthEffect(StatEffect statEffect) {
        health.addEffect(statEffect);
    }

    /**
     * Removes a stat effect from the health.
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
     * @param boost New boost.
     */
    public void addPowerBoost(Boost boost) {
        power.addBoost(boost);
    }

    /**
     * Removes a boost from the power.
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
     * @param boost New boost.
     */
    public void addDefenseBoost(Boost boost) {
        defense.addBoost(boost);
    }

    /**
     * Removes a boost from the power.
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
     * @return the maximum life
     */
    public int getMaxHealth() {
        return health.MAX;
    }

    public int getEnergy() {
        return energy.getValue();
    }

    public int getMaxEnergy() {
        return energy.MAX;
    }

    public int getDefense() {
        return defense.getValue();
    }

    public int getPower() {
        return power.getValue();
    }
}