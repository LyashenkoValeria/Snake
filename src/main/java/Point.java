import java.awt.*;

public class Point {
    int x;
    int y;
    Color color = new Color(0, 255, 128);

    public Point(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x*10, y*10 , 10, 10);
    }
}
