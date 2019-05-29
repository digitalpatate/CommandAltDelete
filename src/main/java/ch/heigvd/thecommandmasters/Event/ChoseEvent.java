package ch.heigvd.thecommandmasters.Event;

import ch.heigvd.thecommandmasters.Entity;

public class ChoseEvent
{
    private Entity chosenOne;

    public ChoseEvent(Entity chosenOne) {
        this.chosenOne = chosenOne;
    }

    public Entity getChosenOne() {
        return chosenOne;
    }
}

