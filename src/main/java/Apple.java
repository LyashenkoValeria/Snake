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
            x = new Random().nextInt(Game.sizeX);
            y = new Random().nextInt(Game.sizeY);
        } while (Game.inSnake(x,y));
        this.setX(x);
        this.setY(y);
    }
}
