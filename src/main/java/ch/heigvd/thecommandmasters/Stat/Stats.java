package ch.heigvd.thecommandmasters.Stat;

public class Stats {
    int value;
    int maxValue;
    String name;

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
     * methode that reduces the stat
     * @param value
     */
    public void reduceStat(int value){

        if(this.value < value)
            value = 0;

        this.value -= value;
    }

    /**
     * methode that increases the stat
     * @param value
     */
    public void increaseStat(int value){
        if((this.value + value) == maxValue)
            this.value = maxValue;

        this.value += value;
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


}
