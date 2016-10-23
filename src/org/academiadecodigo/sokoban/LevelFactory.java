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
    private int maxLevel = 7;


    /**
     * Level ONE factory
     * Map is defined in array of Strings
     * New array of objects is created with the number of objects in the map
     * Player is created in position
     * Objects are created in the array of objects
     */

    public GameObject[] level1(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", " ", "c", "x", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(3, 4, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * Level TWO factory
     */

    public GameObject[] level2(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "x", "b", "b", "b"},
                {"b", "b", " ", " ", " ", " ", "b", "b", "b"},
                {"b", "b", " ", "b", "b", " ", "b", "b", "b"},
                {"b", "b", " ", " ", "c", "c", " ", "b", "b"},
                {"b", "b", " ", "b", " ", " ", " ", "b", "b"},
                {"b", "b", "x", " ", " ", " ", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(6, 4, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * Level THREE factory
     */

    public GameObject[] level3(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", " ", " ", "b", "b", "b", "b"},
                {"b", " ", " ", " ", " ", " ", "c", " ", "b"},
                {"b", " ", "b", " ", " ", "b", "c", " ", "b"},
                {"b", " ", "x", " ", "x", "b", " ", " ", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(6, 5, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * Level FOUR factory
     */

    public GameObject[] level4(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", " ", " ", "b", "b", "b", "b", "b", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", " ", "x", "b", "c", "c", " ", " ", "b"},
                {"b", " ", " ", "b", " ", "b", "b", "b", "b"},
                {"b", " ", "x", " ", " ", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(6, 4, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * Level FIVE factory
     */

    public GameObject[] level5(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "x", " ", "b", " ", " ", "b", "b"},
                {"b", "b", " ", " ", "c", " ", " ", "b", "b"},
                {"b", "b", "x", " ", "c", "b", " ", "b", "b"},
                {"b", "b", " ", " ", "c", " ", " ", "b", "b"},
                {"b", "b", "x", " ", "b", " ", " ", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(6, 4, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * Level SIX factory
     */

    public GameObject[] level6(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", " ", " ", " ", " ", "b", "b"},
                {"b", "b", "b", " ", "b", "b", " ", "b", "b"},
                {"b", "b", "b", " ", "b", " ", "c", " ", "b"},
                {"b", " ", "x", "x", "b", " ", "c", " ", "b"},
                {"b", " ", " ", " ", " ", " ", " ", " ", "b"},
                {"b", " ", " ", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(6, 2, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * Level SEVEN factory
     */

    public GameObject[] level7(Field field) {
        String[][] map = {
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
                {"b", "b", "b", "b", "b", " ", " ", "b", "b"},
                {"b", "b", "b", "b", "b", " ", " ", "b", "b"},
                {"b", "b", "b", "b", "b", "c", "x", "b", "b"},
                {"b", "b", " ", " ", " ", "c", "x", "b", "b"},
                {"b", "b", " ", "b", " ", "c", "x", "b", "b"},
                {"b", "b", " ", " ", " ", " ", "b", "b", "b"},
                {"b", "b", "b", "b", "b", "b", "b", "b", "b"}};

        objectsToReturn = new GameObject[numberOfObjects(map, field.getCols(), field.getRows())];
        objectsToReturn[0] = new Player(5, 2, false);

        fillArray(map, field.getCols(), field.getRows());

        return objectsToReturn;

    }

    /**
     * The array of Game Objects is populated based on the map
     * For each position in the map an object is created based on the String printed on the map
     */

    private void fillArray(String[][] map, int cols, int rows) {
        pos = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col].equals("b")) {
                    objectsToReturn[pos] = new Brick(col, row, false);
                    pos++;
                } else if (map[row][col].equals("x")) {
                    objectsToReturn[pos] = new SpotX(col, row, true);
                    pos++;
                } else if (map[row][col].equals("c")) {
                    objectsToReturn[pos] = new Box(col, row, false);
                    pos++;
                }
            }
        }
    }

    /**
     * Counter of objects in the map
     * The number is then returned as the length of the GameObjects array
     * Initial counter as 1 to count the Player
     */

    private int numberOfObjects(String[][] map, int cols, int rows) {
        int counter = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col].equals("b") || map[row][col].equals("x") || map[row][col].equals("c")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * When current level is completed the next one is loaded
     */

    public GameObject[] getNextLevel(int level, Field field) {
        if (level == 1) {
            return level2(field);
        } else if (level == 2) {
            return level3(field);
        } else if (level == 3) {
            return level4(field);
        } else if (level == 4) {
            return level5(field);
        } else if (level == 5){
            return level6(field);
        } else if (level == 6){
            return level7(field);
        } else {
            return null;
        }
    }

    /**
     * Resets current level
     */

    public GameObject[] resetLevel(int level, Field field) {
        if (level == 1) {
            return level1(field);
        } else if (level == 2) {
            return level2(field);
        } else if (level == 3) {
            return level3(field);
        } else if (level == 4) {
            return level4(field);
        } else if (level == 5){
            return level5(field);
        } else if (level == 6){
            return level6(field);
        } else {
            return level7(field);
        }
    }

    public int getMaxLevel(){
        return maxLevel;
    }
}
