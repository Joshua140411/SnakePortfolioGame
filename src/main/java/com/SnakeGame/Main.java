package com.SnakeGame;

import javax.swing.*;
import java.awt.*;

class Main extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Main() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        MainMenu menu = new MainMenu(this);
        mainPanel.add(menu, "MENU");

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
        cardLayout.show(mainPanel, "MENU");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
