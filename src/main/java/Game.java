import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Game  {
    private int startX = 10;
    private int startY = 10;
    private int speed = 100;
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
        window.setSize(410, 410);
        window.setResizable(false);
        window.setVisible(true);

        field = new Canvas();
        field.setBackground(Color.black);
        window.getContentPane().add(BorderLayout.CENTER, field);

        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP && snake.direction != down) {
                    snake.direction = up;
                }
                if (key == KeyEvent.VK_DOWN && snake.direction != up) {
                    snake.direction = down;
                }

                if (key == KeyEvent.VK_LEFT && snake.direction != right) {
                    snake.direction = left;
                }
                if (key == KeyEvent.VK_RIGHT && snake.direction != left) {
                    snake.direction = right;
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


    public class Canvas extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (!inGame) {
                g.setColor(Color.white);
                g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
                g.drawString("Нажмите Пробел, чтобы начать игру", 50, 180);
            } else {
                snake.paint(g);
                apple.paint(g);
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
