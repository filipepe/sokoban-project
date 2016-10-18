package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.GameObject;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game {
    private Field field;
    private GameObject[] objects;
    private CollisionDetector collisionDetector;


    public void init(){
        objects = new GameObject[];
        collisionDetector = new CollisionDetector(objects.length);

    }

    public void startGame(){

    }


    private boolean comparePositon(){

    }

    private void quit(){

    }

    private void reset(){

    }
}
