package ch.heigvd.thecommandmasters.Stat;

public class Boost {

    private final int value;
    private int duration;
    private BoostType type;

    /**
     * Constructor
     *
     * @param value
     * @param duration
     * @param type
     */
    public Boost(int value, int duration, BoostType type) {
        this.value = value;
        this.duration = duration;
        this.type = type;
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

    public int getValue() {
        return value;
    }

    public int getDuration() {
        return duration;
    }

    public BoostType getType() {
        return type;
    }
}
