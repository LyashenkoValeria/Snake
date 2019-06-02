import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SnakeTest {
    Apple apple = new Apple();
    Snake snakeTest = new Snake(10, 10, 3, 1);

    @Test
    public void move() {
        ArrayList<Point> bodyTest = new ArrayList<Point>();
        bodyTest.add(0, new Point(9, 10));
        bodyTest.add(0, new Point(10, 10));
        bodyTest.add(0, new Point(11, 10));
        Point head = new Point(11, 10);
        snakeTest.snake.add(0, head);
        snakeTest.snake.remove(snakeTest.snake.size() - 1);
        assertEquals(snakeTest.snake, bodyTest);

        bodyTest.add(0, new Point(12, 10));
        Apple apple = new Apple();
        apple.setX(12);
        apple.setY(10);
        head = new Point(12, 10);
        snakeTest.snake.add(0, head);
        if (snakeTest.eat(apple)){
            apple.eat();
            snakeTest.score++;
        }
        assertEquals(1, snakeTest.score);
        assertEquals(bodyTest, snakeTest.snake);
    }

    @Test
    public void eat() {
        apple.setX(10);
        apple.setY(10);
        assertTrue(snakeTest.eat(apple));

        apple.setX(20);
        apple.setY(10);
        assertFalse(snakeTest.eat(apple));
    }
}