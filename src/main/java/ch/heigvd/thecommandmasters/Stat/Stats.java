package ch.heigvd.thecommandmasters.Stat;

import java.util.Iterator;
import java.util.LinkedList;

public class Stats {

    private int value;
    public final int MAX;
    private String name;
    private LinkedList<StatEffect> effects;

    /**
     * Constructor
     * @param maxValue
     * @param name
     */
    public Stats(int maxValue, String name){
        this.MAX = maxValue;
        this.value = MAX;
        this.name = name;
        this.effects = new LinkedList<>();
    }

    /**
     * methode that increases the stat
     * @param amount
     */
    public void changeStat(int amount) {

        int result = value + amount;

        if (result >= MAX) {
            value = MAX;
            return;
        }

        if (result <= 0) {
            value = 0;
            return;
        }

        value = result;
    }

    public void addEffect(StatEffect st){
        effects.add(st);
    }

    public void removeEffect(StatEffect st){
        effects.remove(st);
    }

    /**
     * methode that get back the name
     * @return name
     */
    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }

    public void updateEffects() {

        Iterator<StatEffect> it = effects.iterator();
        while (it.hasNext()) {

            StatEffect effect = it.next();

            changeStat(effect.getValue());
            effect.reduceDuration();

            if (effect.getDuration() <= 0) {
                it.remove();
            }
        }
    }
}
