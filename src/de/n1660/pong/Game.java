package de.n1660.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Niggo on 28.04.2017.
 */

public class Game extends Canvas implements Runnable {


    public final static int WINW = 1500;
    public final static int WINH = 600;

    public boolean running = true;
    public static int COLR= 0;
    public static int COLG = 0;
    public static int COLB = 0;

    public Ball ball;
    public Racket racketL;
    public Racket racketR;

    public Game() {
        //initialize window
        JFrame window = new JFrame("Log");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WINW, WINH);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(this);
        window.setVisible(true);

        racketL = new Racket(5);
        racketR = new Racket(1480);
        ball = new Ball();

        start();

    }

    public static void main(String args[]) {
        new Game();
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (running) {
            ball.update();
            racketR.update();
            racketL.update();

            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null) {
                this.createBufferStrategy(3);
                continue;
            }

            Graphics graphics = bs.getDrawGraphics();

            graphics.setColor(new Color(COLR, COLG, COLB));
            graphics.fillRect(0, 0, WINW, WINW);

            ball.render(graphics);
            racketR.render(graphics);
            racketL.render(graphics);

            graphics.dispose();
            bs.show();
        }
    }
}