package ch.heigvd.thecommandmasters.Stat;

public class StatEffect {
    int duration;
    int value;
    String name;
    Stats stat;
    StatsType st;


    /**
     * Constructor
     * @param value
     * @param duration
     * @param name
     * @param stat
     */
    StatEffect(int value, int duration, String name, Stats stat, StatsType st){
        this.value    = value;
        this.duration = duration;
        this.name     = name;
        this.stat     = stat;

    }


    /**
     * the method use the method of the class stat for increase the stat
     */
    public void increaseEffectStat(){
        stat.changeStat(value);
        duration--;
    }

    /**
     * the method use the method of the class stat for reduce the stat
     */
    public void reduceEffectStat(){
        stat.changeStat(value);
        duration--;
    }

    public int getValue(){
        return value;
    }

}
