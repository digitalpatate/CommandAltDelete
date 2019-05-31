package ch.heigvd.thecommandmasters.Character;

public class Entity {

    private int id;
    private String name;
    private int position;

    Entity(int life, int power, int shield){

    }

    public Entity(String name, int id) {

        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}