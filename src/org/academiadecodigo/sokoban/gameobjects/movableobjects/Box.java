package org.academiadecodigo.sokoban.gameobjects.movableobjects;

import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class Box extends MovableObject {
    public Box(int col, int row, boolean crossable) {
        super(col, row, crossable);
    }

    @Override
    public boolean isMovable(Direction direction){

    }

    @Override
    public void move(Direction direction){

    }
}
