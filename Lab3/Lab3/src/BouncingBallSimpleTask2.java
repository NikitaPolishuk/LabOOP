import java.awt.*;
import java.util.Formatter;
import javax.swing.*;

public class BouncingBallSimpleTask2 extends JPanel {
    // Container box's width and height
    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;

    private int rectX1 = 50;
    private int rectY1 = 50;
    private int rectX2 = 100;
    private int rectY2 = 100;
    private int rectSpeedX = 6;
    private int rectSpeedY = 7;

    private static final int UPDATE_RATE = 30; // Number of refresh per second

    /** Constructor to create the UI components and init game objects. */
    public BouncingBallSimpleTask2() {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

        // Start the ball bouncing (in its own thread)
        Thread gameThread = new Thread() {
            public void run() {
                while (true) { // Execute one update step
                    rectX1 += rectSpeedX;
                    rectY1 += rectSpeedY;
                    rectX2 += rectSpeedX;
                    rectY2 += rectSpeedY;

                    if (rectX2 >= BOX_WIDTH) {
                        rectSpeedX = -rectSpeedX;
                    } else if (rectY2 >= BOX_HEIGHT) {
                        rectSpeedY = -rectSpeedY;
                    }
                    if (rectX1 <= 0) {
                        rectSpeedX = -rectSpeedX;
                    } else if (rectY1 <= 0) {
                        rectSpeedY = -rectSpeedY;
                    }

                    // Refresh the display
                    repaint(); // Callback paintComponent()
                    // Delay for timing control and give other threads a chance
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                    } catch (InterruptedException ex) { }
                }
            }
        };
        gameThread.start();  // Callback run()
    }

    /** Custom rendering codes for drawing the JPanel */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background

        // Draw the box
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        // Draw the RECT
        var colorRect = new ColoredRect(rectX1, rectY1, rectX2, rectY2);
        colorRect.setInColor(Color.BLUE);
        colorRect.setOutColor(Color.GREEN);
        colorRect.draw(g);

        // Display the RECT information
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("Rect X1(%d) X2(%d) X3(%d) X4(%d) Speed=(%d,%d)", rectX1, rectY1, rectX2, rectY2, rectSpeedX, rectSpeedY);
        g.drawString(sb.toString(), 20, 30);
    }

    /** main program (entry point) */
    public static void main(String[] args) {
        // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Set up main window (using Swing's Jframe)
                JFrame frame = new JFrame("A Bouncing Rect");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BouncingBallSimpleTask2());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
