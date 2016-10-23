package org.academiadecodigo.sokoban;

/**
 * Created by codecadet on 18/10/16.
 */
public class Main {
    public static void main(String[] args) {
        Game g1 = new Game();
        g1.init();
        KeyboardInput keyboard = new KeyboardInput(g1);

    }
}
