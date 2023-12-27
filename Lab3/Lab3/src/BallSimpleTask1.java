import java.awt.*;
import java.util.Formatter;
import javax.swing.*;


public class BallSimpleTask1 extends JPanel {
    // Container box's width and height
    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;

    // Ball's properties
    private float ballRadius = 200;            // Ball's radius
    private float ballX = ballRadius + 50; // Ball's center (x, y)
    private float ballY = ballRadius + 20;

    private static String FIO = "Polishchuk Nikita Alekseevich";
    private static String Group = "IVT-5";

    /** Constructor to create the UI components and init game objects. */
    public BallSimpleTask1() {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }
    /** Custom rendering codes for drawing the JPanel */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background

        // Draw the box
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        // Draw the ball
        g.setColor(Color.BLUE);
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                (int)(2 * ballRadius), (int)(2 * ballRadius));
    }

    /** main program (entry point) */
    public static void main(String[] args) {
        // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Set up main window (using Swing's Jframe)
                JFrame frame = new JFrame(String.format("%s %s", FIO, Group));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BallSimpleTask1());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
