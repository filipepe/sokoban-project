package org.academiadecodigo.sokoban.gameobjects;

/**
 * Created by codecadet on 18/10/16.
 */
public class Brick extends NonMovableObject{
    public Brick(int col, int row, boolean crossable) {
        super(col, row, crossable);
    }
}
