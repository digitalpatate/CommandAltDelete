package ch.heigvd.thecommandmasters.Stat;

import java.util.Iterator;
import java.util.LinkedList;

public class Feature {

    public final int VALUE; // The feature's base value
    private final String name;
    private LinkedList<Boost> boosts;

    /**
     * constructor
     * @param value
     * @param name
     */
    public Feature(int value, String name){
        this.VALUE = value;
        this.name = name;
        this.boosts = new LinkedList<>();
    }

    /**
     * update the boost
     */
    public void updateBoosts() {

        Iterator<Boost> it = boosts.iterator();
        while (it.hasNext()) {

            Boost boost = it.next();
            boost.reduceDuration();

            if (boost.getDuration() <= 0) {
                it.remove();
            }
        }
    }

    /**
     * add one boost in the tab
     * @param boost is one of the boost choose by the player
     */
    public void addBoost(Boost boost) {
        boosts.add(boost);
    }

    /**
     * remove the boost in the tab
     * @param boost is one of the boost choose by the player
     */
    public void removeBoost(Boost boost) {
        boosts.remove(boost);
    }

    /**
     * method that get back the name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * method that get back the value with the boosts
     * @return the boosted total value
     */
    public int getValue() {

        int total = VALUE;
        for (Boost boost : boosts) {
            total += boost.getValue();
        }

        return total;
    }


}
