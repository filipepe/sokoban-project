package org.academiadecodigo.sokoban.gameobjects;

import org.academiadecodigo.sokoban.CollisionDetector;
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

    /**
     * Can the Player cross the object?
     */

    public boolean isCrossable(){
        return crossable;
    }

    /**
     * What is the object position?
     */

    public Position getPosition() {
        return position;
    }
}
