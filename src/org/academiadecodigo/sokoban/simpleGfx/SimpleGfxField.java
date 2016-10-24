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
    private boolean quit;

    /**
     * Background Color
     */

    private final Color GROUND = new Color(0, 255, 197);

    /**
     * Padding value
     */

    public static final int PADDING = 10;

    /**
     * Cell size in Pixels (SIZE*SIZE)
     */

    public static final int SIZE = 100;

    /**
     * Width Value in pixels
     */

    public static final int WIDTH = 900;

    /**
     * Height Value in pixels
     */

    public static final int HEIGHT = 800;

    public SimpleGfxField(boolean gameStarted, boolean quit) {
        this.cols = WIDTH / SIZE;
        this.rows = HEIGHT / SIZE;
        this.gameStarted = gameStarted;
        this.quit = quit;
        init();
    }

    /**
     * The background is created with a super fresh color
     * If the game hasn't started yet it loads a legendary masterpiece made by one of the most
     * memorable Code Cadets ever
     *
     * @see SimpleGfxField#show()
     */

    private void init() {
        rectangle = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        rectangle.setColor(GROUND);
        if (!gameStarted) {
            startPicture = new Picture(PADDING, PADDING, "resources/background/init.png");
        }
        if(quit){
            startPicture = new Picture(PADDING, PADDING, "resources/background/credits.png");
        }
        show();
    }

    /**
     * Creates a new position in the graphic field
     */

    public void createPos(GameObject[] gameObject) {
        positions = new SimpleGfxPosition(gameObject);
    }

    /**
     * Moves object picture in a direction
     */

    public void moveInDirection(int posArray, Direction direction) {
        positions.moveInDirection(posArray, direction);
    }

    /**
     * Changes the Box picture when it is in the same position as a SpotX
     */

    public void changeBoxPicture(int position, boolean onSpot) {
        positions.changeBoxPicture(position, onSpot);
    }

    /**
     * Changes Player picture
     * @see SimpleGfxPosition#changePlayerPicture(Direction, int, boolean)
     */

    public void changePlayerPicture(Direction direction, int actualPicture, boolean onSpot) {
        positions.changePlayerPicture(direction, actualPicture, onSpot);
    }

    /**
     * Changes Player picture when level is completed
     * @see SimpleGfxPosition#changeWinnerPicture(int)
     */

    public void winner(int actualPicture) {
        positions.changeWinnerPicture(actualPicture);
    }

    /**
     * Loads credits picture
     */

    public void credits(){

        creditsPicture = new Picture(PADDING, PADDING, "resources/background/credits.png");

        creditsPicture.draw();
    }

    /**
     * The background is filled with that beautiful color
     * Then the legendary masterpiece is drawn into place
     * Game as started
     */

    public void show() {
        rectangle.fill();
        if (!gameStarted) {
            startPicture.draw();
            gameStarted = true;
        }
        if (quit){
            startPicture.draw();
            quit = false;
        }
    }

    /**
     * Hides initial menu or quit menu
     */

    public void deleteStartPicture() {

        startPicture.delete();
    }

    /**
     * Converts row into pixel height
     */

    public static int rowToY(int row) {
        return row * SIZE;
    }

    /**
     * Converts col into pixel width
     */

    public static int columnToX(int column) {
        return column * SIZE;
    }
}
