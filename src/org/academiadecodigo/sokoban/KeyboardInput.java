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
    private boolean gameStarted;

    public KeyboardInput(Game gameUser){
        this.gameUser = gameUser;
        start();
    }

    public void start(){
        k = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent reset = new KeyboardEvent();
        KeyboardEvent start = new KeyboardEvent();

        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        left.setKey(KeyboardEvent.KEY_LEFT);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        reset.setKey(KeyboardEvent.KEY_R);
        start.setKey(KeyboardEvent.KEY_N);

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        reset.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(up);
        k.addEventListener(down);
        k.addEventListener(left);
        k.addEventListener(right);
        k.addEventListener(reset);
        k.addEventListener(start);
    }


    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()){
            // TODO: 21/10/16 adicionar condicao de bloqueio de teclas
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
            case KeyboardEvent.KEY_N:
                if(!gameStarted){
                    gameUser.startGame();
                    gameStarted = true;
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
