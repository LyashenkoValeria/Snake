import java.util.ArrayList;

public class Snake {

    ArrayList<Point> snake = new ArrayList<Point>();
    boolean life = true;
    int direction;
    int score = 0;


    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            snake.add(point);
        }
        this.direction = direction;
    }

    public void move(){
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        switch (direction){
            case (1):{
                y--;
                Game.upDir = false;
                break;
            }
            case (2):{
                y++;
                Game.downDir = false;
                break;
            }
            case (3):{
                x--;
                Game.leftDir = false;
                break;
            }
            case (4):{
                x++;
                Game.rightDir = false;
                break;
            }
        }

        if (x > Game.sizeX-1) {life = false;}
        if (x < 0) {life = false;}
        if (y > Game.sizeY-1) {life = false;}
        if (y < 0) {life = false;}

        if(Game.inSnake(x,y)) {life = false;}

        snake.add(0, new Point(x, y));
        if (eat(Game.apple)) {
            Game.apple.eat();
            score++;
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    boolean eat(Apple apple) {
        return ((snake.get(0).getX() == apple.getX()) && (snake.get(0).getY() == apple.getY()));
    }
}
