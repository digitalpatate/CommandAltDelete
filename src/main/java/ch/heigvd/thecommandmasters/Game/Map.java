package ch.heigvd.thecommandmasters.Game;


import ch.heigvd.thecommandmasters.Entity;

public class Map {

    private Entity stage[];
    private Entity p1,p2;
    private int positionP1,positionP2;


public Map(int mapSize, Entity p1, Entity p2){

    stage= new Entity[mapSize];
    this.p1=p1;
    this.p2=p2;

    positionP1=0;
    positionP2=mapSize-1;

    stage[positionP1]=p1;
    stage[positionP2]=p2;

}


    public int getPositionP1() {
        return positionP1;
    }


    public int getPositionP2() {
        return positionP2;
    }
}
