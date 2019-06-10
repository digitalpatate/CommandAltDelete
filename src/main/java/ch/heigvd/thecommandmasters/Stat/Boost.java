package ch.heigvd.thecommandmasters.Stat;

public class Boost {

    private final int value;
    private int duration;

    /**
     * Constructor
     *
     * @param value
     * @param duration
     */
    public Boost(int value, int duration) {
        this.value = value;
        this.duration = duration;
    }

    /**
     * reduce the duration when the entity lose health or attack
     */
    public void reduceDuration() {
        if (duration <= 1) {
            duration = 0;
        } else {
            duration--;
        }
    }

    /**
     *
     * @return the value of the boost
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @return the duration of the boost
     */
    public int getDuration() {
        return duration;
    }

}
