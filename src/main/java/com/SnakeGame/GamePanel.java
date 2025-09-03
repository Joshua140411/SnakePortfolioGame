package com.SnakeGame;

import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private Point head;
    private char direction = 'R';

    // Game logic
    boolean running;
    Timer gameTimer;

    public GamePanel() {
        // Window preferences
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        setFocusable(true);

        // Game utilities
        snake = new ArrayList<>();
        head = new Point(WIDTH / 2, HEIGHT / 2);
        snake.add(head);

        // Game logic
        running = true;
        PlayerController playerController = new PlayerController(this);
        addKeyListener(playerController);
        gameTimer = new Timer(DELAY, playerController);
        gameTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        snake.forEach(p -> g.fillRect(p.x, p.y, TILE_SIZE, TILE_SIZE));
    }

}
