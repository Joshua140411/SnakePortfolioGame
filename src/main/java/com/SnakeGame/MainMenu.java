package com.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private JLabel scoreLabel;

    public MainMenu(Main frame) {
        setLayout(new GridBagLayout());
        setBackground(new Color(30, 30, 30));

        JLabel title = new JLabel("SNAKE GAME");
        title.setForeground(Color.GREEN);
        title.setFont(new Font("Arial", Font.BOLD, 50));

        JButton startBtn = new JButton("Spiel starten");
        JButton creditsBtn = new JButton("Credits");
        JButton exitBtn = new JButton("Spiel beenden");

        startBtn.setBackground(Color.GREEN);
        startBtn.setForeground(Color.BLACK);
        creditsBtn.setBackground(Color.YELLOW);
        creditsBtn.setForeground(Color.BLACK);
        exitBtn.setBackground(Color.RED);
        exitBtn.setForeground(Color.WHITE);

        startBtn.addActionListener(e -> frame.startGame());
        creditsBtn.addActionListener(e -> frame.showCredits());
        exitBtn.addActionListener(e -> System.exit(0));

        scoreLabel = new JLabel("Gesamtpunkte: 0", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(title, gbc);
        gbc.gridy = 1;
        add(startBtn, gbc);
        gbc.gridy = 2;
        add(creditsBtn, gbc);
        gbc.gridy = 3;
        add(exitBtn, gbc);
        gbc.gridy = 4;
        add(scoreLabel, gbc);
    }

    public void updateScoreLabel(int totalScore) {
        scoreLabel.setText("Gesamtpunkte: " + totalScore);
    }
}
