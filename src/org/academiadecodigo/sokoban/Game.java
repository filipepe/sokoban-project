package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;
import org.academiadecodigo.sokoban.simpleGfx.SimpleGfxField;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game {

/*
   * Abstract Game Field
*/
    private Field field;
/*
   * Array of Game Objects
*/
    private GameObject[] objects;
/*
   * Player and Boxes Collision Detector
*/
    private CollisionDetector collisionDetector;
/*
   * Graphic Game Field
*/
    private SimpleGfxField simpleGfxField;
    //Array of spotsX
    private int[] spots;
    //Array of boxes
    private int[] boxes;
    //Factor of Game Levels
    private LevelFactory factory;
    //Game Level
    private int level;
    //Blocker for Keyboard used on initial menu, credits and when a Player wins the game
    private boolean keyboardBlocked;
    //Checks if game has started
    private boolean gameStarted;


/**
    * Initializes a new Game, constructing an abstract and graphic fields, and a new level (through LevelFactory)
    * Level1 objects are called, a counter for Boxes and Xs is created and a new collision detector
    * The method to change level is called
    * The music is set to play
 */

    public void init() {
        factory = new LevelFactory();
        field = new Field(9, 8);
        objects = factory.level1(field);
        collisionDetector = new CollisionDetector(objects);
        simpleGfxField = new SimpleGfxField(10, 10, false);

        spots = spotXIndex();
        boxes = boxIndex();
        changeLevel();
        startMusic();

    }

/**
    * Erases Menu Picture and instances level objects in the graphics field
*/

    public void startGame() {
        gameStarted = true;
        simpleGfxField.deleteStartPicture();
        simpleGfxField.createPos(objects);

    }

/**
    * Checks if a Player can move in a given direction
    * Returns -1 if it's OK, or the position on the abstract field if NOT OK
*/

    private int isMovable(Direction direction, GameObject gameObject) {

        int position = collisionDetector.checkCollision(direction, gameObject);
        if (position == -1) {
            return -1;
        }
        if (objects[position] instanceof Box || objects[position] instanceof Brick) {
            return position;
        }
        return -1;
    }

/**
    * Moves Player in both fields (abstract and graphic)
    *
    * If Player doesn't change direction of movement, the position is updated in given direction
    * along with the designated picture
    * @see Player#setActualPicture
    * @see SimpleGfxField#changePlayerPicture
    * Checks if Player is in a SpotX position
    *
    * If there's a Box in the new position, and the box is movable, the box moves in given direction
    * alongside with Player
    * Checks if Player or Box are in a SpotX position
    *
    * Else checks if Player is on a SpotX position
*/

    public void movePlayer(Direction direction) {
        if (!switchDirection(direction)) {
            int pos;
            pos = isMovable(direction, objects[0]);
            if (pos == -1) {
                objects[0].getPosition().moveInDirection(direction);
                simpleGfxField.moveInDirection(0, direction);
                ((Player) objects[0]).setActualPicture();
                playerInSpot();
            } else if (objects[pos] instanceof Box) {
                int pos2;
                pos2 = isMovable(direction, objects[pos]);
                if (pos2 == -1) {
                    objects[0].getPosition().moveInDirection(direction);
                    simpleGfxField.moveInDirection(0, direction);
                    ((Player) objects[0]).setActualPicture();
                    playerInSpot();
                    objects[pos].getPosition().moveInDirection(direction);
                    simpleGfxField.moveInDirection(pos, direction);
                    verifyBoxSpot();
                }
            }
        } else {
            playerInSpot();
        }
    }

    /**
     * SpotX counter
     * Returns the position of each SpotX in the GameObjects array
     * for further comparisons
     */

    private int[] spotXIndex() {

        int counter = 0;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof SpotX) counter++;
        }

        int[] toReturn = new int[counter];
        counter = 0;

        for (int i = 0; i < objects.length; i++) {

            if (objects[i] instanceof SpotX) {
                toReturn[counter] = i;
                counter++;
            }
        }
        return toReturn;
    }

    /**
     * Box counter
     * Returns the position of each box in the GameObjects array
     * for further comparisons
     */

    private int[] boxIndex() {
        int counter = 0;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Box) counter++;
        }

        int[] toReturn = new int[counter];
        counter = 0;

        for (int i = 0; i < objects.length; i++) {

            if (objects[i] instanceof Box) {
                toReturn[counter] = i;
                counter++;
            }
        }

        return toReturn;
    }

    /**
     * Checks if Player next move will change direction
     * If so, changes Player picture to match new direction
     */

    private boolean switchDirection(Direction direction) {

        if (((Player) objects[0]).getDirection() != direction) {
            ((Player) objects[0]).setDirection(direction);
            ((Player) objects[0]).setActualPicture(0);
            return true;
        }
        return false;
    }

    /**
     * Checks if there are boxes and spotX with the same position
     * Changes picture of box if true
     * @see SimpleGfxField#changeBoxPicture(int, boolean)
     */

    private void verifyBoxSpot() {
        int count = 0;

        for (int i : boxes) {
            for (int k : spots) {
                if (objects[i].getPosition().comparePosition(objects[k].getPosition())) {
                    simpleGfxField.changeBoxPicture(i, true);
                    count++;
                    break;
                } else {
                    simpleGfxField.changeBoxPicture(i, false);
                }
            }
        }
        if (count == spots.length) {
            try {
                winner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Animation for Player when a Level is cleared
     * Keyboard is blocked and a timer for animation is used
     */

    private void winner() throws InterruptedException {
        keyboardBlocked = true;

        ((Player) objects[0]).setActualPicture(0);

        long startTime = System.currentTimeMillis();
        Timer t = new Timer("next-level");
        t.schedule(new CelebrationTimer(), 100, 300);
    }

    /**
     * Checks if Player is on a SpotX position and changes Player picture accordingly
     */

    private void playerInSpot() {

        for (int i : spots) {
            if (objects[0].getPosition().comparePosition(objects[i].getPosition())) {
                simpleGfxField.changePlayerPicture(((Player) objects[0]).getDirection(), ((Player) objects[0]).getActualPicture(), true);
                return;
            } else {
                simpleGfxField.changePlayerPicture(((Player) objects[0]).getDirection(), ((Player) objects[0]).getActualPicture(), false);
            }
        }
    }

    /**
     * Returns to Initial Menu
     */

    public void quit() {
        objects = factory.level1(field);
        collisionDetector = new CollisionDetector(objects);
        simpleGfxField = new SimpleGfxField(10, 10, false);

        spots = spotXIndex();
        boxes = boxIndex();
        level = 1; // TODO: 22/10/16 changeLevel??

        gameStarted = false;
    }

    /**
     * Resets actual level
     * Objects positions are set to the beginning of level
     */

    public void reset() {
        objects = factory.resetLevel(level, field);
        collisionDetector = new CollisionDetector(objects);
        simpleGfxField = new SimpleGfxField(10, 10, true);
        simpleGfxField.createPos(objects);
        spots = spotXIndex();
        boxes = boxIndex();
    }

    /**
     * Changes Game level after completion
     * If level limit is reached shows credits
     * @see Game#changeLevel()
     */

    private void nextLevel() {

        if (level != 0) {
            objects = factory.getNextLevel(level, field);
            collisionDetector = new CollisionDetector(objects);
            simpleGfxField = new SimpleGfxField(10, 10, true);
            simpleGfxField.createPos(objects);
            spots = spotXIndex();
            boxes = boxIndex();
            changeLevel();
        } else {
            simpleGfxField.credits();
        }
    }

    /**
     * Increases int level until maximum
     * When maximum is reached sets level to 0
     */

    private void changeLevel() {
        if (level < factory.getMaxLevel() - 1) {
            level++;
        } else {
            level = 0;
        }
    }

    /**
     * Plays game AWESOME soundtrack
     * So awesome that it is an infinite loop
     * Cardigans rulz
     */

    private void startMusic() {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musicas/cardigans.wav"));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Private class with timer for the Celebration Dance
     */

    private class CelebrationTimer extends TimerTask {

        private int count;

        /**
         * Changes Player picture when a level is completed
         * Does Celebration Dance then calls next level
         */

        @Override
        public void run() {
            simpleGfxField.winner(((Player) objects[0]).getActualPicture());
            ((Player) objects[0]).setActualPicture();
            count++;

            if (count > 12) {
                this.cancel();
                nextLevel();
                keyboardBlocked = false;
            }
        }
    }

    /**
     * Is the keyboard blocked?
     */

    public boolean isKeyboardBlocked() {
        return keyboardBlocked;
    }

    /**
     * Has the game started yet?
     */

    public boolean isGameStarted() {
        return gameStarted;
    }
}
