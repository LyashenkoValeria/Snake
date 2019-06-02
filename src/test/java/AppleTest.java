import org.junit.Test;

import static org.junit.Assert.*;

public class AppleTest {
    Apple apple1 = new Apple();
    Apple apple2 = new Apple();
    Snake snakeTest = new Snake(10, 10, 3, 1);

    @Test
    public void eat() {
        apple1.setX(10);
        apple1.setY(20);
        apple2.setX(-1);
        apple2.setY(-1);
        apple1.eat();
        assertEquals(apple1, apple2);
    }

    @Test
    public void isEaten() {
        apple1.setX(0);
        apple1.setY(0);
        apple1.eat();
        assertTrue(apple1.isEaten());

        apple1.setX(10);
        apple1.setY(10);
        assertFalse(apple1.isEaten());
    }

    @Test
    public void create() {
        Game.snake = snakeTest;
        apple1.create();
        boolean check = false;
        if (apple1.getX() > 0 && apple1.getX() < Game.sizeX && apple1.getY() > 0 && apple1.getY() < Game.sizeY){
            check = true;
        }
        assertTrue(check);
    }
}