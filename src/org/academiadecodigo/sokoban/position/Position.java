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


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

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

    private void moveUp() {
        row--;
    }

    private void moveDown() {
        row++;
    }

    private void moveLeft() {
        col--;
    }

    private void moveRight() {
        col++;
    }

    @Override
    public String toString() {
        return "Position{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}

