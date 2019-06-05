package ch.heigvd.thecommandmasters.Stat;

import java.util.LinkedList;

public class Stats {
    int value;
    int maxValue;
    String name;
    LinkedList<StatEffect> listStatsEffect;

    /**
     * Constructor
     * @param maxValue
     * @param name
     */
    public Stats(int maxValue,String name){
        this.maxValue = maxValue;
        this.name     = name;
    }


    /**
     * methode that increases the stat
     * @param value
     */
    public void changeStat(int value){
        if((this.value + value) == maxValue)
            this.value = maxValue;

        if((this.value + value) < value)
            value = 0;

        this.value += value;
    }


    public void addEffect(StatEffect st){
        listStatsEffect.add(st);
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

    public void update(){
        for(StatEffect st : listStatsEffect){
            changeStat(st.getValue());
        }
    }


}
