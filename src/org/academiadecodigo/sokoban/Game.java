package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.MovableObject;
import org.academiadecodigo.sokoban.position.Direction;
import org.academiadecodigo.sokoban.simpleGfx.SimpleGfxField;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game {
    private Field field;
    private GameObject[] objects;
    private CollisionDetector collisionDetector;
    private SimpleGfxField urso;


    public void init(){
        LevelFactory fabrica = new LevelFactory();
        field = new Field(9,8);
        objects = fabrica.createLevel(field);
        collisionDetector = new CollisionDetector(objects);
        urso  = new SimpleGfxField(10,10);
        urso.createPos(objects);



       //startGame();

    }

    public void startGame() throws InterruptedException {

        for(int i = 0; i < objects.length; i++ ){
            System.out.println(objects[i]);
        }


        /*
        System.out.println(objects[0].getPosition());
        movePlayer(Direction.UP);
        System.out.println(objects[0].getPosition());
        movePlayer(Direction.RIGHT);
        System.out.println(objects[0].getPosition());
        movePlayer(Direction.DOWN);
        System.out.println(objects[0].getPosition());
        for(int i = 0; i < objects.length; i++ ){
            System.out.println(objects[i]);
        }
        movePlayer(Direction.DOWN);
        System.out.println(objects[0].getPosition());

*/
        //Thread.sleep(5000);
        for(int i = 0; i < objects.length; i++ ){
            System.out.println(objects[i]);
        }


    }


    private GameObject isMovable(Direction direction, GameObject gameObject){

        GameObject object = collisionDetector.checkCollision(direction,gameObject);

        if(object instanceof Box  || object instanceof Brick) {
           return object;
        }
        return null;

    }

    public void movePlayer(Direction direction){
        GameObject o;
        o = isMovable(direction, objects[0]);
        if(o == null){
            objects[0].getPosition().moveInDirection(direction);
            urso.moveInDirection(0,direction);
        }
        else if(o instanceof Box){
            GameObject o2;
            o2 = isMovable(direction,o);
            if(o2 == null){
                objects[0].getPosition().moveInDirection(direction);
                urso.moveInDirection(0,direction);
                o.getPosition().moveInDirection(direction);
            }
        }
    }

    private void quit(){

    }

    private void reset(){

    }
}
