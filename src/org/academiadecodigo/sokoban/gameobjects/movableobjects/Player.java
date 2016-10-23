package org.academiadecodigo.sokoban.gameobjects.movableobjects;

import org.academiadecodigo.sokoban.CollisionDetector;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class Player extends MovableObject {
    private Direction direction;
    private int actualPicture;

    public Player(int col, int row, boolean crossable) {
        super(col, row, crossable);
        direction = Direction.DOWN;
        actualPicture = 0;

    }

    /**
     * Sets Player direction
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Retrieves actual Player direction
     */

    public Direction getDirection() {
        return direction;
    }

    /**
     * Retrieves actual Player picture
     */

    public int getActualPicture() {
        return actualPicture;
    }

    /**
     * Sets new picture for Player when Player changes direction
     */

    public void setActualPicture(int actualPicture) {
        this.actualPicture = actualPicture;
    }

    /**
     * Gives a new value to actualPicture of Player according to previous picture
     * */

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

    /**
     * Moves the Player in given direction
     */

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
