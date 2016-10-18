package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.GameObject;

/**
 * Created by codecadet on 18/10/16.
 */
public class TesteFactory {
    public static void main(String[] args) {
        LevelFactory fabrica = new LevelFactory();
        Field field = new Field(7,7);
        GameObject[] objectos = fabrica.creatLevel(field);

        for(int i = 0; i < objectos.length; i++ ){
            System.out.println(objectos[i]);
        }
    }
}
