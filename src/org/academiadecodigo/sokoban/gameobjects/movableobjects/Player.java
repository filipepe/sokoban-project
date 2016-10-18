package org.academiadecodigo.sokoban.gameobjects.movableobjects;

import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class Player extends MovableObject {
    private Direction direction;

    public Player(int col, int row, boolean crossable) {
        super(col, row, crossable);
    }

    private void pushBox(Direction direction){

    }

    @Override
    public boolean isMovable(Direction direction){

throw new UnsupportedOperationException();
    }

    @Override
    public void move(Direction direction){

    }
}
