import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void inSnake() {
        Point pointTest = new Point(9, 10);
        Point pointTest2 = new Point(11, 10);
        Snake snakeTest = new Snake(10, 10, 3, 1);
        Game.snake = snakeTest;
        assertTrue(Game.inSnake(pointTest.getX(), pointTest.getY()));
        assertFalse(Game.inSnake(pointTest2.getX(), pointTest2.getY()));
    }
}