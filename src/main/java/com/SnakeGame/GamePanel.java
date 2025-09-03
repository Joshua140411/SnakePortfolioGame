package com.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
