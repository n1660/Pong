package de.n1660.pong;

import java.awt.*;

/**
 * Created by Niggo on 28.04.2017.
 */
public class Ball {

    private int x;
    private int y;
    private int r;
    private double velx;
    private double vely;
    private Color color;
    private boolean hit;

    public Ball () {
        this.x = 750;
        this.y = 300;
        this.r = 10;
        this.velx = 10;
        this.vely = 10;
        this.color = new Color(0xAE, 0xAE, 0xAE);
        this.hit = false;
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawOval(x, y, 10, 10);
    }
}
