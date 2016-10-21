package org.academiadecodigo.sokoban;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

/**
 * Created by codecadet on 19/10/16.
 */
public class TestMain {
    public static void main(String[] args) {
        Game g1 = new Game();
        g1.init();
        KeyboardInput keyboard = new KeyboardInput(g1);


        //g1.startGame();
    }
}

