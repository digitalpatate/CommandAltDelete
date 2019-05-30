package ch.heigvd.thecommandmasters.Stat;

public class Boost {
    String name;
    int value;
    int duration;
    Feature feature;

    /**
     * Constructor
     * @param feature
     * @param name
     * @param valeur
     * @param duree
     */
    Boost(Feature feature, String name, int valeur, int duree){
        this.name   = name;
        this.duration  = duration;
        this.value = value;
        this.feature = feature;
    }


    /**
     * reduce the duration when the entity lose health or attack
     */
    void reduceDuration(){
        if(duration <= 1) {
            duration = 0;
        }
        else{
            duration--;
        }
    }

    /**
     * increaseBoot, create the new feature boosted
     * @return
     */
    Feature increaseBoot(){
        Feature f = new Feature(feature.getValue() + value);
        return f;
    }

}
