package org.academiadecodigo.sokoban.gameobjects;

/**
 * Created by codecadet on 18/10/16.
 */
public abstract class NonMovableObject extends GameObject{
    public NonMovableObject(int col, int row, boolean crossable) {
        super(col, row, crossable);
    }
}
