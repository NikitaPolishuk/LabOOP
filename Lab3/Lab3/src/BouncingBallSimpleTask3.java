import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class BouncingBallSimpleTask3 extends JPanel {

    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;

    private static final int RECT_HEIGHT = 50;
    private static final int RECT_WIDTH = 50;

    private static int maxSpeed = 5;
    private static int minSpeed = 1;

    private static final int UPDATE_RATE = 60;

    private static Rectangle[] rectArr = new Rectangle[30];
    private static final Random rand = new Random();

    private static int getRandomSpeed() {
        return rand.nextInt(maxSpeed) + minSpeed;
    }

    public BouncingBallSimpleTask3() {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    for (Rectangle rectangle : rectArr)
                    {
                        rectangle.move();

                        if (rectangle.getX2() >= BOX_WIDTH)
                        {
                            rectangle.setSpeedX(-rectangle.getSpeedX());
                        }
                        else if (rectangle.getY2() >= BOX_HEIGHT)
                        {
                            rectangle.setSpeedY(-rectangle.getSpeedY());
                        }

                        if (rectangle.getX1() <= 0)
                        {
                            rectangle.setSpeedX(-rectangle.getSpeedX());
                        }
                        else if (rectangle.getY1() <= 0)
                        {
                            rectangle.setSpeedY(-rectangle.getSpeedY());
                        }
                    }

                    repaint();

                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        for (Rectangle rectangle : rectArr) {
            if (rectangle instanceof ColoredRect a)
            {
                a.setOutColor(Color.BLUE);
                a.setInColor(Color.GREEN);
                a.draw(g);
            }
            else if (rectangle instanceof DrawableRect a)
            {
                a.setOutColor(Color.YELLOW);
                a.draw(g);
            }
            else
            {
                g.setColor(Color.RED);
                g.drawRect(rectangle.getX1(), rectangle.getY1(), rectangle.getWidth(), rectangle.getHeight());
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < rectArr.length; i++) {
            if (i < 10) {
                rectArr[i] = new Rectangle(0, 0, RECT_WIDTH, RECT_HEIGHT);
            } else if (i < 20) {
                rectArr[i] = new DrawableRect(0, 0, RECT_WIDTH, RECT_HEIGHT);
            } else {
                rectArr[i] = new ColoredRect(0, 0, RECT_WIDTH, RECT_HEIGHT);
            }
            rectArr[i].setSpeedX(getRandomSpeed());
            rectArr[i].setSpeedY(getRandomSpeed());
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("A Bouncing Rect Task3");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BouncingBallSimpleTask3());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}