package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.MovableObject;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game {
    private Field field;
    private GameObject[] objects;
    private CollisionDetector collisionDetector;


    public void init(){
        LevelFactory fabrica = new LevelFactory();
        field = new Field(7,7);
        objects = fabrica.createLevel(field);
        collisionDetector = new CollisionDetector(objects);

       startGame();

    }

    public void startGame(){

    }


    private boolean isMovable(Direction direction, GameObject gameObject){

        GameObject object = collisionDetector.checkCollision(direction,gameObject);

        if(object == null){
            ((MovableObject)gameObject).move(direction);
        }
        if(object instanceof Box) {
            isMovable(direction, object);
        }
        if(object instanceof Brick) {
            return false;
        }


    }

    private void quit(){

    }

    private void reset(){

    }
}
