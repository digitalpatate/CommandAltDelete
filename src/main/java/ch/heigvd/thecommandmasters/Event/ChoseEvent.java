package ch.heigvd.thecommandmasters.Event;

import ch.heigvd.thecommandmasters.Character.EntityClass;

public class ChoseEvent
{
    private EntityClass chosenOne;

    public ChoseEvent(EntityClass chosenOne) {
        this.chosenOne = chosenOne;
    }

    public EntityClass getChosenOne() {
        return chosenOne;
    }
}

