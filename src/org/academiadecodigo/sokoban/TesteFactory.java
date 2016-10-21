package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 18/10/16.
 */
public class TesteFactory {
    public static void main(String[] args) {
        LevelFactory fabrica = new LevelFactory();
        Field field = new Field(7,7);
        GameObject[] objectos = fabrica.level1(field);

        for(int i = 0; i < objectos.length; i++ ){
            System.out.println(objectos[i]);
        }


        //test positions
        System.out.println(objectos[0].getPosition());
       objectos[0].getPosition().moveInDirection(Direction.DOWN);
        System.out.println(objectos[0].getPosition());

        objectos[0].getPosition().moveInDirection(Direction.RIGHT);
        System.out.println(objectos[0].getPosition());

        objectos[0].getPosition().moveInDirection(Direction.UP);
        System.out.println(objectos[0].getPosition());

        objectos[0].getPosition().moveInDirection(Direction.LEFT);
        System.out.println(objectos[0].getPosition());

        objectos[0].getPosition().moveInDirection(Direction.DOWN);
        System.out.println(objectos[0].getPosition());




    }
}
