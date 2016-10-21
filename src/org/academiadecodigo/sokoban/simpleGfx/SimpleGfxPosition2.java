package org.academiadecodigo.sokoban.simpleGfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;
import org.academiadecodigo.sokoban.position.Position;

/**
 * Created by codecadet on 21/10/16.
 */
public class SimpleGfxPosition2 {
    private Picture picture;
    //SimpleGfxField simpleGfxField;
    private int col;
    private int row;

    public SimpleGfxPosition2(int col, int row, GameObject gameObject) {
        this.col = col;
        this.row = row;


        init(gameObject);
    }

    private void init(GameObject gameObject) {
        if (gameObject instanceof Player) {
            picture = new Picture(gameObject.getPosition().getCol() * 100 + 10, gameObject.getPosition().getRow() * 100 + 10, "resources/ash_front/sprite_0.png");
        }
        if (gameObject instanceof Box) {
            picture = new Picture(gameObject.getPosition().getCol() * 100 + 10, gameObject.getPosition().getRow() * 100 + 10, "resources/Box/sprite_0.png");
        }
        if (gameObject instanceof SpotX) {
            picture = new Picture(gameObject.getPosition().getCol() * 100 + 10, gameObject.getPosition().getRow() * 100 + 10, "resources/SpotX/SpotX.png");
        }
        if (gameObject instanceof Brick) {
            picture = new Picture(gameObject.getPosition().getCol() * 100 + 10, gameObject.getPosition().getRow() * 100 + 10, "resources/Brick/brick.png");
        }

        picture.draw();
    }

    public void moveInDirection(Direction direction) {
        switch (direction) {
            case UP:
                picture.translate(0, -100);
                row--;

                break;
            case DOWN:
                picture.translate(0, 100);
                row++;
                break;
            case LEFT:
                picture.translate(-100, 0);
                col--;
                break;
            case RIGHT:
                picture.translate(100, 0);
                col++;
                break;
        }
    }

    public void changeBoxPicture(boolean onSpot) {
        Picture pic;
        if (onSpot) {
            pic = new Picture(picture.getX(), picture.getY(), "Box/sprite_1.png");
            picture.delete();
            picture = pic;
            picture.draw();
        } else {
            pic = new Picture(picture.getX(), picture.getY(), "Box/sprite_0.png");
            picture.delete();
            picture = pic;
            picture.draw();
        }
    }

    public void changePlayerPicture(Direction direction, int actualPicture, boolean onSpot) {
        if (onSpot) {
            actualPicture += 4;
            switch (direction) {
                case UP:
                    picture.load("ash_back/sprite_" + actualPicture + ".png");
                    break;
                case DOWN:
                    picture.load("ash_front/sprite_" + actualPicture + ".png");
                    break;
                case LEFT:
                    picture.load("ash_left/sprite_" + actualPicture + ".png");
                    break;
                case RIGHT:
                    picture.load("ash_right/sprite_" + actualPicture + ".png");
                    break;
                default:
                    picture.load("ash_back/sprite_" + actualPicture + ".png");
                    break;
            }
        } else {
            switch (direction) {
                case UP:
                    picture.load("ash_back/sprite_" + actualPicture + ".png");
                    break;
                case DOWN:
                    picture.load("ash_front/sprite_" + actualPicture + ".png");
                    break;
                case LEFT:
                    picture.load("ash_left/sprite_" + actualPicture + ".png");
                    break;
                case RIGHT:
                    picture.load("ash_right/sprite_" + actualPicture + ".png");
                    break;
                default:
                    picture.load("ash_back/sprite_" + actualPicture + ".png");
                    break;
            }

        }
    }

    public void winner(int actualPicture) {
        System.out.println(actualPicture);

        switch (actualPicture) {
            case 0:
                picture.load("ash_winner/sprite_" + actualPicture + ".png");
                System.out.println("here");
                break;
            case 1:
                picture.load("ash_winner/sprite_" + actualPicture + ".png");
                break;
            case 2:
                picture.load("ash_winner/sprite_" + actualPicture + ".png");
                break;
            case 3:
                picture.load("ash_winner/sprite_" + actualPicture + ".png");
                break;
            default:
                picture.load("ash_winner/sprite_" + actualPicture + ".png");
                break;
        }


    }
}
