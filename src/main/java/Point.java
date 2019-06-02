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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Point point = (Point) obj;
            if (point.x == this.x && point.y == this.y)
                return true;
        }
        return false;
    }
}
