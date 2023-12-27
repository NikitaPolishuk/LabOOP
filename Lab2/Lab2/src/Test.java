import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(10, 10);
        Rectangle rect3 = new Rectangle(5, 5, 20, 10);

        System.out.println("Created rectangles:");
        System.out.println("rect1: " + rect1.rect_print());
        System.out.println("rect2: " + rect2.rect_print());
        System.out.println("rect3: " + rect3.rect_print());

        rect1.move(5, 5);
        rect2.move(10, 10);
        rect3.move(2, 2);

        System.out.println("Moved rectangles:");
        System.out.println("rect1: " + rect1.rect_print());
        System.out.println("rect2: " + rect2.rect_print());
        System.out.println("rect3: " + rect3.rect_print());

        Rectangle u1 = new Rectangle(2, 2, 30, 30);
        Rectangle u2 = new Rectangle(25, 20, 26, 27);
        u1.union(u2);
        System.out.println("u1 union u2:");
        System.out.println(u1.rect_print());
    }
}