package com.SnakeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements ActionListener, KeyListener {

    private final GamePanel gamePanel;

    public PlayerController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gamePanel.running) {
            move();
        }
        gamePanel.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (gamePanel.getDirection() != 'D') {
                    gamePanel.setDirection('U');
                }
                break;
            case KeyEvent.VK_S:
                if (gamePanel.getDirection() != 'U') {
                    gamePanel.setDirection('D');
                }
                break;
            case KeyEvent.VK_A:
                if (gamePanel.getDirection() != 'R') {
                    gamePanel.setDirection('L');
                }
                break;
            case KeyEvent.VK_D:
                if (gamePanel.getDirection() != 'L') {
                    gamePanel.setDirection('R');
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void move() {
        Point newHead = gamePanel.getHead();
        switch (gamePanel.getDirection()) {
            case 'U':
                newHead.y -= GamePanel.TILE_SIZE;
                break;
            case 'D':
                newHead.y += GamePanel.TILE_SIZE;
                break;
            case 'L':
                newHead.x -= GamePanel.TILE_SIZE;
                break;
            case 'R':
                newHead.x += GamePanel.TILE_SIZE;
                break;
        }
    }
}
