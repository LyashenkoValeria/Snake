import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Game  {
    private int startX = 10;
    private int startY = 10;
    private int speed = 100;
    static int sizeX = 40;
    static int sizeY = 38;
    static boolean upDir = false;
    static boolean downDir = false;
    static boolean leftDir = false;
    static boolean rightDir = false;
    private int up = 1;
    private int down = 2;
    private int left = 3;
    private int right = 4;
    static Apple apple;
    static Snake snake;
    JFrame window;
    static Canvas field;
    boolean life = true;
    boolean inGame = false;

    public static void main(String[] args){
      new Game().start();
    }

    public void start() {
        window = new JFrame("Змейка");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500, 200);
        window.setSize(sizeX*10+10, sizeY*10+30);
        window.setResizable(false);
        window.setVisible(true);

        field = new Canvas();
        field.setBackground(Color.black);
        window.getContentPane().add(BorderLayout.CENTER, field);

        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if(!leftDir && !rightDir) {
                    if (key == KeyEvent.VK_UP && snake.direction != down) {
                        upDir = true;
                        snake.direction = up;
                    }
                    if (key == KeyEvent.VK_DOWN && snake.direction != up) {
                        downDir = true;
                        snake.direction = down;
                    }
                }
                if (!upDir && !downDir) {
                    if (key == KeyEvent.VK_LEFT && snake.direction != right) {
                        leftDir = true;
                        snake.direction = left;
                    }
                    if (key == KeyEvent.VK_RIGHT && snake.direction != left) {
                        rightDir = true;
                        snake.direction = right;
                    }
                }
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                }
            }
        });
        snake = new Snake(startX, startY, 3, right);
        apple = new Apple();
        while (life) {
            field.repaint();
            if (inGame) {
                snake.move();
                if (apple.isEaten()) {
                    apple.create();
                }

                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                life = snake.life;
            }
            field.repaint();
        }
    }

    static boolean inSnake(int x, int y) {
        for (Point point : snake.snake) {
            if ((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    static void paintPoint(Graphics g, Point p) {
        g.setColor(p.color);
        g.fillRect(p.x*10, p.y*10 , 10, 10);
    }

    void paintApple(Graphics g, Apple apple){
        g.setColor(apple.color);
        g.fillOval(apple.x*10, apple.y*10 , 10, 10);
    }

    void paintSnake(Graphics g, Snake snake) {
        for (int i = 0; i < snake.snake.size(); i++) {
            Game.paintPoint(g, snake.snake.get(i));
        }
    }

    public class Canvas extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (!inGame) {
                g.setColor(Color.white);
                g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
                g.drawString("Нажмите Пробел, чтобы начать игру", 50, 180);
            } else {
                paintSnake(g, snake);
                paintApple(g, apple);
            }
            if(!life){
               g.setColor(Color.white);
               g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 50));
               g.drawString("Конец игры", 70, 180);
               g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 30));
               g.drawString("Очки: " + snake.score, 100, 230);
            }
        }
    }
}
