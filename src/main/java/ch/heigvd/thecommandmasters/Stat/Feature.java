package ch.heigvd.thecommandmasters.Stat;

public class Feature {
    int value;
    String name;

    /**
     * constructor
     * @param value
     * @param name
     */
    public Feature(int value, String name){
        this.value = value;
        this.name  = name;
    }

    /** TEST
     * constructor with one parametre
     * @param value
     */
    public Feature(int value){
        this.value = value;
        this.name  = "boost";
    }

    /**
     * method that reduces the feature
     * @param value
     */
    public void reduceFeature(int value){

        if(this.value < value)
            value = 0;

        this.value -= value;
    }

    /**
     * method that increases the feature
     * @param value
     */
    public void increaseFeature(int value){
        this.value += value;
    }

    /**
     * method that get back the name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * method that get back the value
     * @return
     */
    public int getValue(){
        return value;
    }


}