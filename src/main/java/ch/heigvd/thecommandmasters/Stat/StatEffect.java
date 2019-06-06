package ch.heigvd.thecommandmasters.Stat;

public class StatEffect {
    int duration;
    int value;
    Stats stat = null;
    StatsType st = null;


    /**
     * Constructor
     * @param value
     * @param duration
     */
    public StatEffect(int value, int duration){
        this.value    = value;
        this.duration = duration;
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

    public void reduceDuration() {
        duration--;
    }

    public int getValue(){
        return value;
    }

    public int getDuration() {
        return duration;
    }
}
