import java.awt.*;

public class DrawableRect extends Rectangle{
    Color outColor = Color.red;

    public void setOutColor(Color outColor) {
        this.outColor = outColor;
    }

    public DrawableRect(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public void draw(Graphics g) {
        g.drawRect(getX1(), getY1(), getWidth(), getHeight());
        g.setColor(outColor);
    }
}
