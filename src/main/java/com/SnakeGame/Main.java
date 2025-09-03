package com.SnakeGame;

import javax.swing.*;
import java.awt.*;

class Main extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CreditsPanel creditsPanel;
    private MainMenu menu;

    public Main() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        creditsPanel = new CreditsPanel(this);
        menu = new MainMenu(this);
        mainPanel.add(menu, "MENU");
        mainPanel.add(creditsPanel, "CREDITS");

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void startGame() {
        GamePanel gamePanel = new GamePanel(this);
        mainPanel.add(gamePanel, "GAME");
        cardLayout.show(mainPanel, "GAME");
        gamePanel.requestFocusInWindow();
        pack();
        setLocationRelativeTo(null);
    }


    public void showMenu() {
        menu.updateScoreLabel(GameStats.totalScore);
        cardLayout.show(mainPanel, "MENU");
        this.pack();
    }

    public void showCredits() {
        creditsPanel.updateUnlockedBlocks(GameStats.totalScore);
        cardLayout.show(mainPanel, "CREDITS");
        this.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
