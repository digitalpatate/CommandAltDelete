package ch.heigvd.thecommandmasters.Character;

import ch.heigvd.thecommandmasters.Stat.*;

import java.util.Iterator;
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

    Entity(int health, int energy, int power, int Defense, String name){
        this.health = new Stats(health, "Health");
        this.energy = new Stats(energy, "Energy");
        this.power = new Feature(power, "Power");
        this.defense = new Feature(Defense, "Defense");
        this.name = name;
        boostAttack = new LinkedList<>();
        boostDefense = new LinkedList<>();
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
        health.changeStat(amount);
    }

    public void damage(int amount){
        int decreaseDamage = 0;
        for(Boost b : boostDefense){
            decreaseDamage += b.getValue();
            b.reduceDuration();
        }

        health.changeStat(amount - decreaseDamage);
    }

    public int attack(){
        int increaseDamage = 0;
        for(Boost b : boostAttack){
            increaseDamage += b.getValue();
            b.reduceDuration();
        }
        return power.getValue() + increaseDamage;
    }

    private void update(){
        Iterator itDefense = boostDefense.iterator();
        while(itDefense.hasNext()){
            Boost b = ((Boost)itDefense.next());
            if(b.getDuration() == 0){
                itDefense.remove();
            }
        }

        Iterator itAttack = boostAttack.iterator();
        while(itAttack.hasNext()){
            Boost b = ((Boost)itAttack.next());
            if(b.getDuration() == 0){
                itAttack.remove();
            }
        }

        health.update();
        energy.update();
    }

    public void applyHealth(StatEffect statEffect){
        health.addEffect(statEffect);
    }

    public void applyEnergy(StatEffect statEffect){
        energy.addEffect(statEffect);
    }

    public void applyBoostDefense(Boost boost){
        boostDefense.add(boost);
    }

    public void applyBoost(Boost boost){
        boostAttack.add(boost);
    }

    public int getHealth(){
        return health.getValue();
    }

    public int getEnergy(){
        return energy.getValue();
    }

    public int getDefense(){
        return defense.getValue();
    }

    public int getPower(){
        return power.getValue();
    }
}