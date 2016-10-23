package org.academiadecodigo.sokoban.gameobjects.movableobjects;

import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */


public abstract class MovableObject extends GameObject {
    public MovableObject(int col, int row, boolean crossable) {
        super(col, row, crossable);
    }

    public abstract void move(Direction direction);
}
