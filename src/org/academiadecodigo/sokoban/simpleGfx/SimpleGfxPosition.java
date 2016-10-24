package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 19/10/16.
 */
public class SimpleGfxPosition {
    private Picture[] picture;
    private int size;
    private int padding;

    /**
     * When a new graphic field is constructed the gameObjects array is populated with
     * Player, Box, SpotX and Brick pictures
     */

    public SimpleGfxPosition(GameObject[] gameObjects) {
        size = SimpleGfxField.SIZE;
        padding = SimpleGfxField.PADDING;

        picture = new Picture[gameObjects.length];

        for (int i = 0; i < picture.length; i++) {
            if (gameObjects[i] instanceof Player) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * size + padding, gameObjects[i].getPosition().getRow() * size + padding, "resources/ash_front/sprite_0.png");
            }
            if (gameObjects[i] instanceof Box) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * size + padding, gameObjects[i].getPosition().getRow() * size + padding, "resources/Box/sprite_0.png");
            }
            if (gameObjects[i] instanceof SpotX) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * size + padding, gameObjects[i].getPosition().getRow() * size + padding, "resources/SpotX/SpotX.png");
            }
            if (gameObjects[i] instanceof Brick) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * size + padding, gameObjects[i].getPosition().getRow() * size + padding, "resources/Brick/brick.png");
            }
        }

        for (int i = picture.length - 1; i >= 0; i--) {
            picture[i].draw();
        }
    }

    /**
     * Moves pictures in a given direction a fixed number of pixels
     */

    public void moveInDirection(int posArray, Direction direction) {
        switch (direction) {
            case UP:
                picture[posArray].translate(0, -size);
                break;
            case DOWN:
                picture[posArray].translate(0, size);
                break;
            case LEFT:
                picture[posArray].translate(-size, 0);
                break;
            case RIGHT:
                picture[posArray].translate(size, 0);
        }
    }

    /**
     * Changes box picture when it's on SpotX
     */

    public void changeBoxPicture(int position, boolean onSpot) {
        Picture pic;
        if (onSpot) {
            pic = new Picture(picture[position].getX(), picture[position].getY(), "resources/Box/sprite_1.png");
            picture[position].delete();
            picture[position] = pic;
            picture[position].draw();
        } else {
            pic = new Picture(picture[position].getX(), picture[position].getY(), "resources/Box/sprite_0.png");
            picture[position].delete();
            picture[position] = pic;
            picture[position].draw();
        }
    }

    /**
     * Changes player picture when Player gets a new direction, whether is on SpotX or not
     */

    public void changePlayerPicture(Direction direction, int actualPicture, boolean onSpot) {
        if (onSpot) {
            actualPicture += 4;
        }

        switch (direction) {
            case UP:
                picture[0].load("resources/ash_back/sprite_" + actualPicture + ".png");
                break;
            case DOWN:
                picture[0].load("resources/ash_front/sprite_" + actualPicture + ".png");
                break;
            case LEFT:
                picture[0].load("resources/ash_left/sprite_" + actualPicture + ".png");
                break;
            case RIGHT:
                picture[0].load("resources/ash_right/sprite_" + actualPicture + ".png");
                break;
            default:
                picture[0].load("resources/ash_back/sprite_" + actualPicture + ".png");
                break;
        }

    }


    /**
     * That's the Winner Dance baby!
     */

    public void changeWinnerPicture(int actualPicture) {
        switch (actualPicture) {
            case 0:
                picture[0].load("resources/ash_winner/sprite_" + actualPicture + ".png");
                break;
            case 1:
                picture[0].load("resources/ash_winner/sprite_" + actualPicture + ".png");
                break;
            case 2:
                picture[0].load("resources/ash_winner/sprite_" + actualPicture + ".png");
                break;
            case 3:
                picture[0].load("resources/ash_winner/sprite_" + actualPicture + ".png");
                break;
            default:
                picture[0].load("resources/ash_winner/sprite_" + actualPicture + ".png");
                break;
        }
    }
}