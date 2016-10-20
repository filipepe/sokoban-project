package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;

/**
 * Created by codecadet on 18/10/16.
 */
public class LevelFactory {
    private GameObject[] objectsToReturn;
    private int pos;

    public GameObject[] createLevel(Field field){
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", " ", " ", " ", "x", " ", " ", " ", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", " ", " ", " ", " ", " ", "c", " ", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map,field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(1,1,false);
        pos = 1;

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    public GameObject[] level1(Field field){
        objectsToReturn = new GameObject[52];
        objectsToReturn[0] = new Player(6,2,false);
        pos = 1;

        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", " ", " ", " ", " ", "b", "b"},
                {"b", "b", "b", " ", "b", "b", " ", "b", "b"},
                {"b", "b", "b", " ", "b", " ", "c", " ", "b"},
                {"b", " ", "x", "x", "b", " ", "c", " ", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", " ", " ", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        fillArray(map, field.getCols(), field.getRows());


        return objectsToReturn;

    }

    private void fillArray(String[][] map, int cols, int rows){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(map[row][col].equals("b") ){
                    objectsToReturn[pos] = new Brick(col, row, false);
                    pos++;
                }else if(map[row][col].equals("x")){
                    objectsToReturn[pos] = new SpotX(col, row, true);
                    pos++;
                }
                else if(map[row][col].equals("c")){
                    objectsToReturn[pos] = new Box(col, row, false);
                    pos++;
                }
            }
        }
    }

    private int numberOfObjects(String[][] map, int cols, int rows){
        int counter = 1;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(map[row][col].equals("b") || map[row][col].equals("x") ||map[row][col].equals("c")){
                    counter++;
                }
            }
        }
        return counter;
    }
}
