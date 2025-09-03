package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    // Window preferences
    private final int TILE_SIZE = 20;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    // Game utilities
    private final ArrayList<Point> snake;
    private Point head;

    public GamePanel() {
        // Window preferences
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        setFocusable(true);

        // Game utilities
        snake = new ArrayList<>();
        head = new Point(WIDTH / 2, HEIGHT / 2);
        snake.add(head);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        snake.forEach(p -> g.fillRect(p.x, p.y, TILE_SIZE, TILE_SIZE));
    }

}
