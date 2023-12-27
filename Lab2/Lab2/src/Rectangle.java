public class Rectangle {
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;
    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX1() {
        return x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY1() {
        return y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX2() {
        return x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY2() {
        return y2;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        CheckingCondition(this);
    }

    public Rectangle(int width, int height) {
        if (width < 0 || height < 0)return;
        x1 = 0;
        y1 = 0;
        x2 = width;
        y2 = height;
    }

    public Rectangle() {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }

    private void CheckingCondition(Rectangle rectangle)
    {
        if(x2 < x1 || y2 < y1)
        {
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = 0;
        }
    }

    public String rect_print() {
        return String.format("(%d, %d), (%d, %d)", x1, y1, x2, y2);
    }

    public void move(int dx, int dy) {

        if (x1 + dx < 0 || x2 + dx < 0)
            return;
        if (y1 + dy < 0 || y2 + dy < 0)
            return;

        x1 += dx;
        x2 += dx;

        y1 += dy;
        y2 += dy;
    }

    public Rectangle union(Rectangle rect) {
        x1 = Math.min(x1, rect.x1);
        x2 =  Math.min(x2, rect.x2);
        y1 = Math.min(y1, rect.y1);
        y2 = Math.min(y2, rect.y2);
        CheckingCondition(this);
        return this;
    }


}
