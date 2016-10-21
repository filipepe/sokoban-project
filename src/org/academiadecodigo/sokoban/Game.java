package org.academiadecodigo.sokoban;

import org.academiadecodigo.sokoban.gameobjects.Brick;
import org.academiadecodigo.sokoban.gameobjects.GameObject;
import org.academiadecodigo.sokoban.gameobjects.SpotX;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Box;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;
import org.academiadecodigo.sokoban.simpleGfx.SimpleGfxField;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 18/10/16.
 */
public class Game {
    private Field field;
    private GameObject[] objects;
    private CollisionDetector collisionDetector;
    private SimpleGfxField simpleGfxField;
    private int[] spots;
    private int[] boxes;
    private LevelFactory factory;
    private int level;

    public void init() {
        factory = new LevelFactory();
        field = new Field(9, 8);
        objects = factory.level1(field);
        collisionDetector = new CollisionDetector(objects);
        // TODO: 21/10/16 change new simplefield
        simpleGfxField = new SimpleGfxField(10, 10, false);

        spots = spotXIndex();
        boxes = boxIndex();
        level = 4;
        startMusic();


    }

    public void startGame() {

        simpleGfxField.deleteStartPicture();

        simpleGfxField.createPos(objects);


    }


    private int isMovable(Direction direction, GameObject gameObject) {

        int position = collisionDetector.checkCollision(direction, gameObject);

        if (position == -1) {
            return -1;
        }

        if (objects[position] instanceof Box || objects[position] instanceof Brick) {
            return position;
        }
        return -1;

    }

    public void movePlayer(Direction direction) {
        if (!switchDirection(direction)) {
            int pos;
            pos = isMovable(direction, objects[0]);
            if (pos == -1) {
                objects[0].getPosition().moveInDirection(direction);
                simpleGfxField.moveInDirection(0, direction);
                ((Player) objects[0]).setActualPicture();
                playerInSpot();
            } else if (objects[pos] instanceof Box) {
                int pos2;
                pos2 = isMovable(direction, objects[pos]);
                if (pos2 == -1) {
                    objects[0].getPosition().moveInDirection(direction);
                    simpleGfxField.moveInDirection(0, direction);
                    ((Player) objects[0]).setActualPicture();
                    playerInSpot();
                    objects[pos].getPosition().moveInDirection(direction);
                    simpleGfxField.moveInDirection(pos, direction);
                    verifyBoxSpot();
                }
            }
        } else {
            playerInSpot();
        }
    }

    private int[] spotXIndex() {

        int counter = 0;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof SpotX) counter++;
        }

        int[] toReturn = new int[counter];
        counter = 0;

        for (int i = 0; i < objects.length; i++) {

            if (objects[i] instanceof SpotX) {
                toReturn[counter] = i;
                counter++;
            }
        }

        return toReturn;

    }

    private int[] boxIndex() {
        int counter = 0;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Box) counter++;
        }

        int[] toReturn = new int[counter];
        counter = 0;

        for (int i = 0; i < objects.length; i++) {

            if (objects[i] instanceof Box) {
                toReturn[counter] = i;
                counter++;
            }
        }

        return toReturn;
    }

    private boolean switchDirection(Direction direction) {

        if (((Player) objects[0]).getDirection() != direction) {
            ((Player) objects[0]).setDirection(direction);
            ((Player) objects[0]).setActualPicture(0);
            return true;
        }
        return false;
    }

    private void verifyBoxSpot() {
        int count = 0;

        for (int i : boxes) {
            for (int k : spots) {
                if (objects[i].getPosition().comparePosition(objects[k].getPosition())) {
                    simpleGfxField.changeBoxPicture(i, true);
                    count++;
                    break;
                } else {
                    simpleGfxField.changeBoxPicture(i, false);
                }
            }
        }
        if (count == spots.length) {
            try {
                winner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void winner() throws InterruptedException {


        ((Player) objects[0]).setActualPicture(0);

        System.out.println("going to loop pictures");
        /*
        for (int i = 0; i < 12; i++) {
            System.out.println("inside for loop");
            //Thread.sleep(200);
            // TODO: 21/10/16 Fix Celebration Dance!
            System.out.println("changing picture to : " + ((Player) objects[0]).getActualPicture());

            simpleGfxField.winner(((Player) objects[0]).getActualPicture());
            //Thread.sleep(5);
            System.out.println("slept");
            ((Player) objects[0]).setActualPicture();
            System.out.println("the new picture is: " + ((Player) objects[0]).getActualPicture());
            System.out.println("thread inside loop: " + Thread.currentThread().getName());
        }

        */
        //simpleGfxField.winner(((Player) objects[0]).getActualPicture());

        long startTime = System.currentTimeMillis();
        Timer t = new Timer("next-level");
        t.schedule(new EuricoTimer(), 100, 300);


    }

    private void playerInSpot() {

        for (int i : spots) {
            if (objects[0].getPosition().comparePosition(objects[i].getPosition())) {
                simpleGfxField.changePlayerPicture(((Player) objects[0]).getDirection(), ((Player) objects[0]).getActualPicture(), true);
                return;
            } else {
                simpleGfxField.changePlayerPicture(((Player) objects[0]).getDirection(), ((Player) objects[0]).getActualPicture(), false);
            }
        }
    }

    private void quit() {


    }

    public void reset() {
        objects = factory.resetLevel(level, field);
        collisionDetector = new CollisionDetector(objects);
        // TODO: 21/10/16 change new simplegraphics
        simpleGfxField = new SimpleGfxField(10, 10, true);
        simpleGfxField.createPos(objects);
        spots = spotXIndex();
        boxes = boxIndex();
    }

    private void nextLevel() {

        if(level != 0) {
            System.out.println("credits");
            objects = factory.getNextLevel(level, field);
            collisionDetector = new CollisionDetector(objects);
            // TODO: 21/10/16 change new simplegraphics
            simpleGfxField = new SimpleGfxField(10, 10, true);
            simpleGfxField.createPos(objects);
            spots = spotXIndex();
            boxes = boxIndex();
            changeLevel();
        }
        else {
            System.out.println("credits");
            simpleGfxField.credits();
        }
    }

    private void changeLevel() {
        if (level < factory.getMaxLevel() - 1) {
            level++;
        } else {
            level = 0;
        }
    }

    private void startMusic() {
        //AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(new File("resources/sample.wav"));
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musicas/cardigans.wav"));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Clip clip1 = AudioSystem.getClip();
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //clip.open(audioInputStream);

    }


    private class EuricoTimer extends TimerTask {

        private int count;


        @Override
        public void run() {
            System.out.println("changing picture to : " + ((Player) objects[0]).getActualPicture());

            simpleGfxField.winner(((Player) objects[0]).getActualPicture());
            //Thread.sleep(5);
            System.out.println("slept");
            ((Player) objects[0]).setActualPicture();
            System.out.println("the new picture is: " + ((Player) objects[0]).getActualPicture());
            System.out.println("thread inside loop: " + Thread.currentThread().getName());
            count++;

            if(count > 12) {
                this.cancel();
                nextLevel();
            }
        }
    }
}
