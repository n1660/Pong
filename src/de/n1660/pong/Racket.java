package de.n1660.pong;

import java.awt.*;

/**
 * Created by Niggo on 28.04.2017.
 */
public class Racket {
    int x;
    int y;
    int w;
    int h;
    Color color = new Color(0xFF, 0xFF, 0xFF);

    public void RacketMove(int dy) {
        if(((y + dy) >= (y/2)) && (y + dy) <= (Game.WINH - (y/2))) {
            this.y += dy;
        }
    }

    public Racket (int x) {
        this.x = x;
        this.y = 5;
        this.w = 10;
        this.h = 80;
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawRect(x, y, w, h);
    }
}
