package com.SnakeGame;

import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class GamePanel extends JPanel {

    // Window preferences
    static final int TILE_SIZE = 20;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int DELAY = 100;

    // Game utilities
    ArrayList<Point> snake;
    private Point apple;
    private Point head;
    private char direction = 'R';

    // Game logic
    private boolean isRunning;
    private Timer gameTimer;
    private Random random;
    private int score = 0;

    public GamePanel() {
        // Window preferences
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        setFocusable(true);

        // Game utilities
        snake = new ArrayList<>();
        random = new Random();
        head = new Point(WIDTH / 2, HEIGHT / 2);
        snake.add(head);

        // Game logic
        isRunning = true;
        spawnApple();
        PlayerController playerController = new PlayerController(this);
        addKeyListener(playerController);
        gameTimer = new Timer(DELAY, playerController);
        gameTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isRunning) {
            g.setColor(Color.RED);
            g.fillOval(apple.x, apple.y, TILE_SIZE, TILE_SIZE);

            g.setColor(Color.black);
            snake.forEach(point -> g.fillRect(point.x, point.y, TILE_SIZE, TILE_SIZE));

            g.setColor(Color.GRAY);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Score: " + score, 10, 20);
        } else {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            String msg = "Game Over";
            g.drawString(msg, (WIDTH - metrics.stringWidth(msg)) / 2, HEIGHT / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            String scoreMsg = "Final Score: " + score;
            g.drawString(scoreMsg, (WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreMsg)) / 2, HEIGHT / 2 + 40);
        }
    }

    void spawnApple() {
        int x = random.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
        int y = random.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
        apple = new Point(x, y);
    }

}
