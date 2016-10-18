package org.academiadecodigo.sokoban.gameobjects.movableobjects;

import org.academiadecodigo.sokoban.CollisionDetector;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class Player extends MovableObject {
    private Direction direction;
    //private CollisionDetector detector;

    public Player(int col, int row, boolean crossable) {
        super(col, row, crossable);
        direction = Direction.DOWN;

    }

    private void pushBox(Direction direction){

    }

    @Override
    public boolean isMovable(Direction direction){

        throw new UnsupportedOperationException();

    }

    @Override
    public void move(Direction direction){
        this.getPosition().moveInDirection(direction);

    }

    @Override
    public String toString() {
        return "Player{" +
                "direction=" + direction +
                '}';
    }
}
