package ch.heigvd.thecommandmasters.Stat;

public class StatEffect {
    int duration;
    int value;
    String name;
    Stats stat;


    /**
     * Constructor
     * @param value
     * @param duration
     * @param name
     * @param stat
     */
    StatEffect(int value, int duration, String name, Stats stat){
        this.value    = value;
        this.duration = duration;
        this.name     = name;
        this.stat     = stat;
    }


    /**
     * the method use the method of the class stat for increase the stat
     */
    public void increaseEffectStat(){
        stat.increaseStat(value);
        duration--;
    }

    /**
     * the method use the method of the class stat for reduce the stat
     */
    public void reduceEffectStat(){
        stat.reduceStat(value);
        duration--;
    }


}
