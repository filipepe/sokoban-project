package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 19/10/16.
 */
public class SimpleGfxField {
    private Rectangle rectangle;
    private SimpleGfxPosition positions;
    private int cols;
    private int rows;
    private Picture startPicture;
    private Picture creditsPicture;
    private boolean gameStarted;
    private final Color GROUND = new Color(0, 255, 197);
    public static final int PADDING = 10;
    public static final int SIZE = 100;

    public SimpleGfxField(int cols, int rows, boolean gameStarted) {
        this.cols = cols;
        this.rows = rows;
        this.gameStarted = gameStarted;
        init();
    }

    // TODO: 21/10/16 remove hard coding

    private void init() {
        rectangle = new Rectangle(PADDING, PADDING, 900, 800);
        rectangle.setColor(GROUND);
        if (!gameStarted) {
            startPicture = new Picture(PADDING, PADDING, "background/init.png");
        }
        show();
    }

    public void createPos(GameObject[] gameObject) {
        positions = new SimpleGfxPosition(gameObject);
    }

    public void moveInDirection(int posArray, Direction direction) {
        positions.moveInDirection(posArray, direction);
    }

    public void changeBoxPicture(int position, boolean onSpot) {
        positions.changeBoxPicture(position, onSpot);
    }


    public void changePlayerPicture(Direction direction, int actualPicture, boolean onSpot) {
        positions.changePlayerPicture(direction, actualPicture, onSpot);
    }

    public void winner(int actualPicture) {
        positions.changeWinnerPicture(actualPicture);
    }

    public void credits(){

        creditsPicture = new Picture(PADDING, PADDING, "background/credits.png");

        creditsPicture.draw();
    }
    /**
     * @see GridPosition#show()
     */

    public void show() {
        rectangle.fill();
        if (!gameStarted) {
            startPicture.draw();
            gameStarted = true;
        }
    }

    public void deleteStartPicture() {

        startPicture.delete();
    }

    /**
     * @see GridPosition#hide()
     */

    public void hide() {

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
