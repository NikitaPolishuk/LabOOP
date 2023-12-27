import java.awt.*;

public class DrawableRect extends Rectangle{
    Color outColor = Color.red;

    public void draw(Graphics g) {
        g.drawRect(getX1(), getY1(), getWidth(), getHeight());
        g.setColor(outColor);
    }
}
