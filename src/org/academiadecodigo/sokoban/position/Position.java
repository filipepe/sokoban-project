package org.academiadecodigo.sokoban.position;

import org.academiadecodigo.sokoban.gameobjects.GameObject;

/**
 * Created by codecadet on 18/10/16.
 */
public class Position {
    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }


    /**
     * Retrieves column
     */

    public int getCol() {
        return col;
    }

    /**
     * Retrieves row
     */

    public int getRow() {
        return row;
    }

    /**
     * Moves in given direction on abstract field
     */

    public void moveInDirection(Direction direction) {

        switch (direction) {
            case UP:
                moveUp();
                break;

            case DOWN:
                moveDown();
                break;

            case LEFT:
                moveLeft();
                break;

            case RIGHT:
                moveRight();
                break;
        }
    }

    /**
     * Moves 1 row Up
     */

    private void moveUp() {
        row--;
    }

    /**
     * Moves 1 row Down
     */

    private void moveDown() {
        row++;
    }

    /**
     * Moves 1 column Left
     */

    private void moveLeft() {
        col--;
    }

    /**
     * Moves 1 column Right
     */

    private void moveRight() {
        col++;
    }

    /**
     * Compares row and column
     * Returns true if position is coincident
     */

    public boolean comparePosition(Position positionToCompare){
            return row == positionToCompare.getRow() && col == positionToCompare.getCol();
    }

    @Override
    public String toString() {
        return "Position{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}

