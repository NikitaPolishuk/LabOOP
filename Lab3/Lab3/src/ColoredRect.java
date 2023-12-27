import java.awt.*;

public class ColoredRect extends DrawableRect {
    private  Color inColor = Color.gray;

    public ColoredRect(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public void setInColor(Color inColor) {
        this.inColor = inColor;
    }

    public void draw(Graphics g) {
        g.setColor(inColor);
        g.fillRect(getX1(), getY1(), getWidth(), getHeight());
        g.setColor(outColor);
        g.drawRect(getX1(), getY1(), getWidth(), getHeight());
    }
}