package ch.heigvd.thecommandmasters.command.action.attack;

public class AttackModifier {

    public final int DISTANCE;
    public final int PERCENTAGE;

    public AttackModifier(int distance, int percentage) {
        this.DISTANCE = distance;
        this.PERCENTAGE = percentage;
    }
}
