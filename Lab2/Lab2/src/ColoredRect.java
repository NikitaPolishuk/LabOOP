import java.awt.*;

public class ColoredRect extends DrawableRect {
    Color inColor = Color.gray;

    public void draw(Graphics g) {
        g.setColor(inColor);
        g.fillRect(getX1(), getY1(), getWidth(), getHeight());
        g.setColor(outColor);
        g.drawRect(getX1(), getY1(), getWidth(), getHeight());
    }
}