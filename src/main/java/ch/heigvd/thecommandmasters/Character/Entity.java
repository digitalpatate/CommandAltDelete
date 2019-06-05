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
    private Feature defence;
    private LinkedList<StatEffect> effects;
    private LinkedList<Boost> boosts;

    Entity(int health, int energy, int power, int Defence, String name){
        this.health = new Stats(health, "Health");
        this.energy = new Stats(energy, "Energy");
        this.power = new Feature(power, "Power");
        this.defence = new Feature(Defence, "Defence");
        this.name = name;
        effects = new LinkedList<>();
        boosts = new LinkedList<>();
    }

    // A supprimer
    public Entity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int amount){
        position += amount;
    }

    public void heal(int amount){
        health.increaseStat(amount);
    }

    public void damage(int amount){
        health.reduceStat(amount);
    }

    public void applyEffect(StatEffect statEffect){
        effects.add(statEffect);
    }

    public void applyBoost(Boost boost){
        boosts.add(boost);
    }

    public int getHealth(){
        return health.getValue();
    }

    public int getEnergy(){
        return energy.getValue();
    }

    public int getDefence(){
        return defence.getValue();
    }

    public int getPower(){
        return power.getValue();
    }


}