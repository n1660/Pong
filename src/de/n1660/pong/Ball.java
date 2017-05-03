package de.n1660.pong;

import java.awt.*;

/**
 * Created by Niggo on 28.04.2017.
 */
public class Ball {

    private Game game;
    private double x;
    private double y;
    private int r;
    private double velx;
    private double vely;
    private Color color;

    public Ball (Game game) {
        this.game = game;
        this.x = 750.0;
        this.y = 300.0;
        this.r = 12;
        this.velx = 0.5;
        this.vely = 0.5;
        this.color = new Color(0xFF, 0xFF, 0xFF);
    }

    public void BallMove(double dx, double dy) {
        if (((x + (2 * r)) < 0) && (velx < 0)) {
            x = 0;
            game.scoreR++;
            color = new Color(0x50, 0xA0, 0xFF);
            respawn();
        } else {
            x += dx;
        }
        if ((x > Game.WINW) && (velx > 0)) {
            x = Game.WINW;
            game.scoreL++;
            color = new Color(0xFF, 0xA0, 0x50);
            respawn();
        } else {
            x += dx;
        }
            y += dy;
        //y-collision
        if (y == 0 || y == (Game.WINH - 2*r)) {
            vely *= -1;
        }
        //racket-collision
        if (x <= (game.getRacketL().x + game.getRacketL().w)) {
            if ((velx < 0) && ((y > game.getRacketL().y) && (y < (game.getRacketL().y + game.getRacketL().h)))) {
                velx *= -1;
            }
        }
        if (x + (2 * r) >= game.getRacketR().x) {
            if ((velx > 0) && ((y > game.getRacketR().y) && (y < (game.getRacketR().y + game.getRacketR().h)))) {
                velx *= -1;
            }
        }
    }

    private void respawn() {
        x = 750;
        y = 300;
    }

    public void update() {
        BallMove(velx, vely);
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval((int) x, (int) y, 2 * r, 2 * r);
    }
}
