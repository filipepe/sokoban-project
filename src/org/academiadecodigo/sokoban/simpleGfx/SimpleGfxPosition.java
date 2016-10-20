package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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

    public SimpleGfxPosition(GameObject[] gameObjects) {

        picture = new Picture[gameObjects.length];

        for (int i = 0; i < picture.length; i++) {
            if (gameObjects[i] instanceof Player) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * 100 + 10, gameObjects[i].getPosition().getRow() * 100 + 10, "resources/ash_front/sprite_0.png");
            }
            if (gameObjects[i] instanceof Box) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * 100 + 10, gameObjects[i].getPosition().getRow() * 100 + 10, "resources/Box/sprite_0.png");
            }
            if (gameObjects[i] instanceof SpotX) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * 100 + 10, gameObjects[i].getPosition().getRow() * 100 + 10, "resources/SpotX/SpotX.png");
            }
            if (gameObjects[i] instanceof Brick) {
                picture[i] = new Picture(gameObjects[i].getPosition().getCol() * 100 + 10, gameObjects[i].getPosition().getRow() * 100 + 10, "resources/Brick/brick.png");
            }
        }

        for (int i = picture.length-1; i >= 0; i--) {
            picture[i].draw();
        }
    }

    public void moveInDirection(int posArray, Direction direction) {
        switch (direction) {
            case UP:
                picture[posArray].translate(0, -100);
                break;
            case DOWN:
                picture[posArray].translate(0, 100);
                break;
            case LEFT:
                picture[posArray].translate(-100, 0);
                break;
            case RIGHT:
                picture[posArray].translate(100, 0);
        }
    }

    public void changeBoxPicture(int position, boolean onSpot) {
        Picture pic;
        if (onSpot) {
            pic = new Picture(picture[position].getX(), picture[position].getY(),"Box/sprite_1.png");
            picture[position].delete();
            picture[position] = pic;
            picture[position].draw();
        } else {
            pic = new Picture(picture[position].getX(), picture[position].getY(),"Box/sprite_0.png");
            picture[position].delete();
            picture[position] = pic;
            picture[position].draw();
        }
    }

    public void changePlayerPicture(Direction direction, int actualPicture, boolean onSpot) {
        if (onSpot) {
            actualPicture += 4;
            switch (direction) {
                case UP:
                    picture[0].load("ash_back/sprite_" + actualPicture+ ".png");
                    break;
                case DOWN:
                    picture[0].load("ash_front/sprite_" + actualPicture + ".png");
                    break;
                case LEFT:
                    picture[0].load("ash_left/sprite_" + actualPicture + ".png");
                    break;
                case RIGHT:
                    picture[0].load("ash_right/sprite_" + actualPicture + ".png");
                    break;
                default:
                    picture[0].load("ash_back/sprite_" + actualPicture + ".png");
                    break;
            }
        } else {
            switch (direction) {
                case UP:
                    picture[0].load("ash_back/sprite_" + actualPicture + ".png");
                    break;
                case DOWN:
                    picture[0].load("ash_front/sprite_" + actualPicture + ".png");
                    break;
                case LEFT:
                    picture[0].load("ash_left/sprite_" + actualPicture + ".png");
                    break;
                case RIGHT:
                    picture[0].load("ash_right/sprite_" + actualPicture + ".png");
                    break;
                default:
                    picture[0].load("ash_back/sprite_" + actualPicture + ".png");
                    break;
            }

        }
    }
}