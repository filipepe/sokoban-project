package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;

/**
 * Created by codecadet on 19/10/16.
 */
public class SimpleGfxPosition {
    private Picture[] picture;

    public SimpleGfxPosition(GameObject[] gameObjects)
    {

        picture = new Picture[gameObjects.length];

        for (int i = 0; i < picture.length; i++) {
            if(gameObjects[i] instanceof Player){
                picture[i] = new Picture(gameObjects[i].getPosition().getCol()*100 + 10, gameObjects[i].getPosition().getRow()*100 + 10, "gameimages/ash_front/sprite_0.png");
            }
            if(gameObjects[i] instanceof Box){
                picture[i] = new Picture(gameObjects[i].getPosition().getCol()*100 + 10, gameObjects[i].getPosition().getRow()*100 + 10, "gameimages/Box/sprite_0.png");
            }
            if (gameObjects[i] instanceof SpotX){
                picture[i] = new Picture(gameObjects[i].getPosition().getCol()*100 + 10, gameObjects[i].getPosition().getRow()*100 + 10, "gameimages/SpotX/SpotX.png");
            }
            if (gameObjects[i] instanceof Brick){
                picture[i] = new Picture(gameObjects[i].getPosition().getCol()*100 + 10, gameObjects[i].getPosition().getRow()*100 + 10, "gameimages/Brick/brick.png");
            }
        }

        for (int i = 0; i < picture.length; i++) {
            picture[i].draw();

        }
    }

    




    /*private void init() {
        simpleGfxGrid = (SimpleGfxGrid) getGrid();
        rectangle = new Rectangle(SimpleGfxGrid.columnToX(getCol()) + SimpleGfxGrid.PADDING,
                SimpleGfxGrid.rowToY(getRow()) + SimpleGfxGrid.PADDING,
                SimpleGfxGrid.SIZE, SimpleGfxGrid.SIZE);

        show();

    }*/

}
