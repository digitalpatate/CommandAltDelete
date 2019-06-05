package ch.heigvd.thecommandmasters.Stat;


public class Boost {
    String name;
    int value;
    int duration;
    Feature feature;
    BoostType bt;

    /**
     * Constructor
     * @param feature
     * @param name
     * @param valeur
     * @param duree
     */
    Boost(Feature feature, String name, int valeur, int duree,BoostType bt){
        this.name   = name;
        this.duration  = duration;
        this.value = value;
        this.feature = feature;
        this.bt = bt;
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

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }

    public int getDuration(){
        return duration;
    }

    public Feature getFeature(){
        return feature;
    }

}
