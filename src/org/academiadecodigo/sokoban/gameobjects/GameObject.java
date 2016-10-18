package org.academiadecodigo.sokoban.gameobjects;

import org.academiadecodigo.sokoban.position.Position;

/**
 * Created by codecadet on 18/10/16.
 */
public abstract class GameObject {
    private Position position;
    private boolean crossable;


    public GameObject(int col, int row , boolean crossable){
        position = new Position(col,row);
        this.crossable = crossable;

    }

    public boolean isCrossable(){
        return crossable;
    }

    public Position getPosition() {
        return position;
    }
}
