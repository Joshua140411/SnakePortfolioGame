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
        if (gamePanel.isRunning()) {
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
        Point head = gamePanel.snake.getFirst();
        Point newHead = new Point(head);

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

        if (newHead.x < 0 || newHead.y < 0 || newHead.x >= gamePanel.getWIDTH() || newHead.y >= gamePanel.getHEIGHT()) {
            gamePanel.setRunning(false);
            GameStats.totalScore += gamePanel.getScore();
            return;
        }


        if (gamePanel.snake.contains(newHead)) {
            gamePanel.setRunning(false);
            GameStats.totalScore += gamePanel.getScore();
            return;
        }


        if (newHead.equals(gamePanel.getApple())) {
            gamePanel.snake.addFirst(newHead);
            gamePanel.setScore(gamePanel.getScore() + 1);
            gamePanel.spawnApple();
        } else {
            gamePanel.snake.addFirst(newHead);
            gamePanel.snake.removeLast();
        }
    }
}
