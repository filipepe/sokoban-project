package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;
import org.academiadecodigo.sokoban.position.Position;

/**
 * Created by codecadet on 18/10/16.
 */
public class CollisionDetector {
    private GameObject[] gameObjects;

    public CollisionDetector(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public int checkCollision(Direction direction, GameObject object) {

        Position tempPosition = adjacentPosition(direction, object);


        if (object instanceof Player) {

            for (int i = 1; i < gameObjects.length; i++) {
                if (!gameObjects[i].getPosition().comparePosition(tempPosition)) {
                    continue;
                }
                if (!(gameObjects[i] instanceof SpotX)) {
                    return i;
                }
            }
            return -1;
        } else {
            for (int i = 1; i < gameObjects.length; i++) {
                if (gameObjects[i] == object || !gameObjects[i].getPosition().comparePosition(tempPosition)) {
                    continue;
                }
                return i;
            }
            return -1;
        }

    }

    private Position adjacentPosition(Direction direction, GameObject gameObject) {

        switch (direction) {
            case UP:
                return new Position(gameObject.getPosition().getCol(), gameObject.getPosition().getRow() - 1);
            case DOWN:
                return new Position(gameObject.getPosition().getCol(), gameObject.getPosition().getRow() + 1);
            case LEFT:
                return new Position(gameObject.getPosition().getCol() - 1, gameObject.getPosition().getRow());
            case RIGHT:
                return new Position(gameObject.getPosition().getCol() + 1, gameObject.getPosition().getRow());
            default:
                System.out.println("something very bad happened!");
                return null;
        }
    }

}
