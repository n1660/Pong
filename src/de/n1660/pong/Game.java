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
    public static int COLR = 0;
    public static int COLG = 0;
    public static int COLB = 0;

    public Ball ball;
    public Racket racketL;
    public Racket racketR;

    public int scoreL = 0;
    public int scoreR = 0;

    private KeyListening keyListening;

    public Game() {
        //initialize window
        JFrame window = new JFrame("Log");
        window.setUndecorated(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WINW, WINH);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(this);
        window.setVisible(true);

        racketL = new Racket(5, new Color(0xFF, 0x70, 0x70));
        racketR = new Racket(1485, new Color(0x70, 0x70, 0xFF));
        ball = new Ball(this);

        keyListening = new KeyListening(this);
        this.addKeyListener(keyListening);

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
            graphics.fillRect(0, 0, WINW, WINH);

            ball.render(graphics);
            racketR.render(graphics);
            racketL.render(graphics);

            graphics.setColor(new Color(0xFF, 0x70, 0x70));
            graphics.drawString(Integer.toString(scoreL), WINW/2 - 50,50);
            graphics.setColor(new Color(0x70, 0x70, 0xFF));
            graphics.drawString(Integer.toString(scoreR), WINW/2 + 50,50);

            graphics.dispose();
            bs.show();
        }
    }

    public Ball getBall() {
        return ball;
    }

    public Racket getRacketL() {
        return racketL;
    }

    public Racket getRacketR() {
        return racketR;
    }
}