package org.academiadecodigo.sokoban.position;

/**
 * Created by codecadet on 18/10/16.
 */
public class Position {
    private int col;
    private int row;

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }


    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public void moveInDirection(Direction direction){
        switch (direction){
            case UP:
                //actualizar coluna e linha e actualizar posicao na matriz
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
        }
    }
}
