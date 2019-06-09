package ch.heigvd.thecommandmasters.displayer;

import ch.heigvd.thecommandmasters.Character.Entity;

public interface Displayer {

    void showDamage(Entity entity, int amount);
    void showHeal(Entity entity, int amount);
    void showMovement(Entity entity, int from, int to);
}
