package ch.heigvd.thecommandmasters.Stat;

public class StatEffect {
    int duration;
    int value;
    Stats stat = null;

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
     * reduce the duration
     */
    public void reduceDuration() {
        duration--;
    }

    /**
     *
     * @return the value of the stat effect
     */
    public int getValue(){
        return value;
    }

    /**
     *
     * @return the duration of the effect
     */
    public int getDuration() {
        return duration;
    }
}
