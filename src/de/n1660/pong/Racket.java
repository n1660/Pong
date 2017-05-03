package de.n1660.pong;

import java.awt.*;

/**
 * Created by Niggo on 28.04.2017.
 */
public class Racket {
    double x;
    double y;
    int w;
    int h;
    int vel;
    Color color;

    public Racket (int x, Color color) {
        this.x = x;
        this.y = Game.WINH/2 - h/2;
        this.w = 10;
        this.h = 80;
        this.vel = 20;
        this.color = color;
    }

    public void RacketMove(int dy) {
        if (((y + dy) > 0) && ((y + h + dy) < (Game.WINH))) {
            this.y += dy;
        }
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int) x, (int) y, w, h);
    }
}
