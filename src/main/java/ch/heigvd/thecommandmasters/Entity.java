package ch.heigvd.thecommandmasters;

public class Entity {

    private String name;
    private int position;
    private int id;



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
