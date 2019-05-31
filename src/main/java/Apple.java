import java.awt.*;
import java.util.Random;

public class Apple extends Point{

    public Apple() {
        super(-1, -1);
        this.color = Color.red;
    }

    public void eat(){
        this.setX(-1);
        this.setY(-1);
    }

    boolean isEaten() {
        return this.getX() == -1;
    }

    public void create(){
        int x, y;
        do {
            x = new Random().nextInt(40);
            y = new Random().nextInt(38);
        } while (Game.inSnake(x,y));
        this.setX(x);
        this.setY(y);
    }

    void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x*10, y*10 , 10, 10);
    }
}
