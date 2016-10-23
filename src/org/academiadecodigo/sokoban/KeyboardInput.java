package org.academiadecodigo.sokoban;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.sokoban.gameobjects.movableobjects.Player;
import org.academiadecodigo.sokoban.position.Direction;

/**
 * Created by codecadet on 19/10/16.
 */
public class KeyboardInput implements KeyboardHandler{
    private Game gameUser;
    private Keyboard k;

    public KeyboardInput(Game gameUser){
        this.gameUser = gameUser;
        start();
    }

    /**
     * Loads a set of keyboard keys to the program
     */

    public void start(){
        k = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent reset = new KeyboardEvent();
        KeyboardEvent start = new KeyboardEvent();
        KeyboardEvent quit = new KeyboardEvent();

        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        left.setKey(KeyboardEvent.KEY_LEFT);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        reset.setKey(KeyboardEvent.KEY_R);
        start.setKey(KeyboardEvent.KEY_N);
        quit.setKey(KeyboardEvent.KEY_Q);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        reset.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(up);
        k.addEventListener(down);
        k.addEventListener(left);
        k.addEventListener(right);
        k.addEventListener(reset);
        k.addEventListener(start);
        k.addEventListener(quit);
    }



    /**
     * Adds game events to keyboard events
     * */

    @Override
    public void keyPressed(KeyboardEvent e) {
        if(!gameUser.isKeyboardBlocked() && gameUser.isGameStarted()) {
            switch (e.getKey()) {
                case KeyboardEvent.KEY_UP:
                        gameUser.movePlayer(Direction.UP);
                    break;
                case KeyboardEvent.KEY_DOWN:
                    gameUser.movePlayer(Direction.DOWN);
                    break;
                case KeyboardEvent.KEY_LEFT:
                    gameUser.movePlayer(Direction.LEFT);
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    gameUser.movePlayer(Direction.RIGHT);
                    break;
                case KeyboardEvent.KEY_R:
                    gameUser.reset();
                    break;
                case KeyboardEvent.KEY_Q:
                    gameUser.quit();
                    break;
            }
        }
        if (!gameUser.isGameStarted() && e.getKey() == KeyboardEvent.KEY_N){
                    gameUser.startGame();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
