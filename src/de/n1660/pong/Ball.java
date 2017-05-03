package de.n1660.pong;

import java.awt.*;

/**
 * Created by Niggo on 28.04.2017.
 */
public class Ball {

    private Game game;
    private int x;
    private int y;
    private int r;
    private int velx;
    private int vely;
    private Color color;

    public Ball (Game game) {
        this.game = game;
        this.x = 750;
        this.y = 300;
        this.r = 25;
        this.velx = 1;
        this.vely = 1;
        this.color = new Color(0x00, 0xFF, 0x90);
    }

    public void BallMove(int dx, int dy) {
        x += dx;
        y += dy;
        //y-collision
        if (y == 0 || y == (game.WINH - 2*r)) {
            vely *= -1;
        }
        //racket-collision
        if (((x + (2 * r)) == (game.getRacketR().x) && ((y - r) > (game.getRacketR().y)) && ((y - (r)) < (game.getRacketR().y) + (game.getRacketR().h))) ||
                ((x + (2 * r)) == (game.getRacketL().x) && ((y - r) > (game.getRacketL().y)) && ((y - (r)) < (game.getRacketL().y) + (game.getRacketL().h)))) {
            velx *= -1;
        }
    }

    public void update() {
        BallMove(velx, vely);
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(x, y, r/2, r/2);
    }
}
