package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 19/10/16.
 */
public class SimpleGfxField {
    private Rectangle rectangle;
    private SimpleGfxPosition positions;
    //private SimpleGfxField simpleGfxField;
    private int cols;
    private int rows;
    public static final int PADDING = 10;
    public static final int SIZE = 100;
    public static final Color GROUND = new Color(0, 255, 197);

    public SimpleGfxField(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        init();
    }


    private void init() {
        rectangle = new Rectangle(PADDING, PADDING, 900, 800);
        rectangle.setColor(GROUND);

        show();

    }

    public void createPos(GameObject[] gameObject){
        positions = new SimpleGfxPosition(gameObject);
    }

    public void moveInDirection(int posArray, Direction direction){
        positions.moveInDirection(posArray, direction);
    }

    public void changeBoxPicture(int position, boolean onSpot){
        positions.changeBoxPicture(position, onSpot);
    }


    public void changePlayerPicture(Direction direction, int actualPicture, boolean onSpot){
        positions.changePlayerPicture(direction,actualPicture,onSpot);
    }



    /**
     * @see GridPosition#show()
     */

    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */

    public void hide() {
        //rectangle.setColor(SimpleGfxColorMapper.getColor(GridColor.NO_COLOR));
        //rectangle.draw();
        rectangle.delete();
    }

    //public GridPosition makeGridPosition(int col, int row) {
       // return new SimpleGfxGridPosition(col, row, this);
    //}


    public static int rowToY(int row) {
        return row * SIZE;
    }


    public static int columnToX(int column) {
        return column * SIZE;
    }
}
