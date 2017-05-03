package de.n1660.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by z003mxbb on 03.05.2017.
 */
public class KeyListening extends KeyAdapter {

    private Game game;

    public KeyListening(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        final int key = e.getKeyCode();
        if (key == KeyEvent.VK_S) {
            game.getRacketL().RacketMove(game.getRacketL().vel);
        }
        if (key == KeyEvent.VK_W) {
            game.getRacketL().RacketMove(-game.getRacketL().vel);
        }
        if (key == KeyEvent.VK_DOWN) {
            game.getRacketR().RacketMove(game.getRacketR().vel);
        }
        if (key == KeyEvent.VK_UP) {
            game.getRacketR().RacketMove(-game.getRacketR().vel);
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
}
