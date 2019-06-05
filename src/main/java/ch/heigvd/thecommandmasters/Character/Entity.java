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
    private Feature defence;
    private LinkedList<Boost> boostAttack;
    private LinkedList<Boost> boostDefense;

    Entity(int health, int energy, int power, int Defence, String name){
        this.health = new Stats(health, "Health");
        this.energy = new Stats(energy, "Energy");
        this.power = new Feature(power, "Power");
        this.defence = new Feature(Defence, "Defence");
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

        health.changeStat(amount);
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
        /*Iterator it = boosts.iterator();
        while(it.hasNext()){
            Boost b = ((Boost)it.next());
            if(b.getDuration() == 0){
                it.remove();
            }
        }

        for()*/
    }

    public void applyHeal(StatEffect statEffect){
        //heal.addEffect(statEffect);
    }

    public void applyBoost(Boost boost){
        //boosts.add(boost);
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