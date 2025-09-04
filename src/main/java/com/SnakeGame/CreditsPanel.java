package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class CreditsPanel extends JPanel {

    private Main frame;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private ArrayList<CreditBlock> blocks;

    public CreditsPanel(Main frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        setBackground(new Color(20, 20, 20));

        // Panels
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(20, 20, 20));
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(20, 20, 20));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(20, 20, 20));

        // Static Credits
        JLabel title = new JLabel("Credits");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.GREEN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel creditsText = new JLabel("Entwickelt von Joshua Sawadda");
        creditsText.setFont(new Font("Arial", Font.BOLD, 20));
        creditsText.setForeground(Color.WHITE);
        creditsText.setBorder(BorderFactory.createEmptyBorder(5, 5, 25, 5));
        creditsText.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(title);
        headerPanel.add(creditsText);
        add(headerPanel, BorderLayout.NORTH);

        // Scrollpanel for information boxes
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        // Button
        JButton backBtn = new JButton("Zurück zum Menü");
        backBtn.setBackground(Color.YELLOW);
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(e -> frame.showMenu());
        JButton unlockAllBtn = new JButton("Alle anzeigen");
        unlockAllBtn.setBackground(Color.GREEN);
        unlockAllBtn.setForeground(Color.BLACK);
        unlockAllBtn.addActionListener(e -> updateUnlockedBlocks(Integer.MAX_VALUE));
        buttonPanel.add(unlockAllBtn);
        buttonPanel.add(backBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Information blocks
        blocks = new ArrayList<>();
        blocks.add(new CreditBlock("Über mich:", TextContent.content1, 5));
        blocks.add(new CreditBlock("Skills:", TextContent.content2, 10));
        blocks.add(new CreditBlock("Projekte:", TextContent.content3, 25));
        blocks.add(new CreditBlock("", TextContent.content4, 50));

        updateUnlockedBlocks(0);
    }


    public void updateUnlockedBlocks(int totalScore) {
        contentPanel.removeAll();

        // Dynamic Unlocks
        blocks.forEach(block -> {
            if (totalScore >= block.requiredScore) {
                if(!Objects.equals(block.header, "")) {
                    JLabel headerText = new JLabel(block.header);
                    headerText.setForeground(Color.WHITE);
                    headerText.setFont(new Font("Arial", Font.BOLD, 20));
                    headerText.setBorder(BorderFactory.createEmptyBorder(0, 15, 3, 15));
                    contentPanel.add(headerText);
                }
                JLabel informationText = new JLabel(block.information);
                informationText.setForeground(Color.WHITE);
                informationText.setFont(new Font("Arial", Font.PLAIN, 12));
                informationText.setBorder(BorderFactory.createEmptyBorder(0, 15, 25, 15));
                contentPanel.add(informationText);
            } else {
                JLabel lockedText = new JLabel("[Block gesperrt – benötigt " + block.requiredScore + " Punkte]");
                lockedText.setForeground(Color.GRAY);
                lockedText.setFont(new Font("Arial", Font.ITALIC, 16));
                lockedText.setBorder(BorderFactory.createEmptyBorder(0, 15, 25, 15));
                contentPanel.add(lockedText);
            }
        });
        revalidate();
        repaint();
    }

    private static class CreditBlock {
        String header;
        String information;
        int requiredScore;

        public CreditBlock(String header, String information, int requiredScore) {
            this.header = header;
            this.information = information;
            this.requiredScore = requiredScore;
        }
    }
}
