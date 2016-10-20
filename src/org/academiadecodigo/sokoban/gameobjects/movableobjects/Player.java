package org.academiadecodigo.sokoban.gameobjects.movableobjects;

import org.academiadecodigo.sokoban.CollisionDetector;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class Player extends MovableObject {
    private Direction direction;
    private int actualPicture;
    //private CollisionDetector detector;

    public Player(int col, int row, boolean crossable) {
        super(col, row, crossable);
        direction = Direction.DOWN;
        actualPicture = 0;

    }

    private void pushBox(Direction direction) {

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getActualPicture() {
        return actualPicture;
    }

    public void setActualPicture(int actualPicture) {
        this.actualPicture = actualPicture;
    }

    public void setActualPicture() {
        switch (actualPicture) {
            case 0:
                actualPicture = 1;
                break;
            case 1:
                actualPicture = 2;
                break;
            case 2:
                actualPicture = 3;
                break;
            case 3:
                actualPicture = 0;
                break;
            default:
                actualPicture = 0;
                break;
        }
    }

    @Override
    public boolean isMovable(Direction direction) {

        throw new UnsupportedOperationException();

    }

    @Override
    public void move(Direction direction) {
        this.getPosition().moveInDirection(direction);

    }

    @Override
    public String toString() {
        return "Player{" +
                "direction=" + direction +
                "Pos: " + getPosition() +
                '}';
    }
}
