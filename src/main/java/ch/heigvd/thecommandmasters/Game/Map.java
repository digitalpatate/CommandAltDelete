package ch.heigvd.thecommandmasters.Game;

import ch.heigvd.thecommandmasters.Character.Entity;

public class Map {

    private Entity stage[];
    private Entity p1,p2;



public Map(int mapSize, Entity p1, Entity p2){

    stage= new Entity[mapSize];
    this.p1=p1;
    this.p2=p2;

    p1.setPosition(0);
    p2.setPosition(mapSize-1);

}


    public  void move (Entity player, int movement, boolean direction){



    }


//    private boolean validMovement(int movement, boolean direction){
//
//    boolean valid =false;
//
//
//    return valid;
//    }

   // -deplacement (foward-backwards)
    //-getplayers

}
