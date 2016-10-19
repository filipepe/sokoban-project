package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.sokoban.gameobjects.GameObject;

/**
 * Created by codecadet on 19/10/16.
 */
public class SimpleGfxPosition {
    private Picture[] picture;

    public SimpleGfxPosition(GameObject[] gameObjects)
    {
       /* picture = new Picture[9];
        picture[0] = new Picture(col * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[1] = new Picture(1 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[2] = new Picture(2 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[3] = new Picture(3 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[4] = new Picture(4 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[5] = new Picture(5 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[6] = new Picture(6 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[7] = new Picture(7 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
        picture[8] = new Picture(8 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, 0 * SimpleGfxField.SIZE + SimpleGfxField.PADDING, "gameimages/brick.jpg");
*/

        picture = new Picture[gameObjects.length];

        for (int i = 0; i < picture.length; i++) {
            picture[i] = new Picture(gameObjects[i].getPosition().getCol()*100 + 10, gameObjects[i].getPosition().getRow()*100 + 10, "gameimages/brick.jpg");
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
