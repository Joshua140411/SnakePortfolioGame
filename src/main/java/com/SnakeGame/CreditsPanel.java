package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreditsPanel extends JPanel {

    private Main frame;
    private JPanel contentPanel;
    private ArrayList<CreditBlock> blocks;

    public CreditsPanel(Main frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBackground(new Color(20, 20, 20));

        JLabel title = new JLabel("Credits", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.GREEN);
        add(title, BorderLayout.NORTH);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        JButton backBtn = new JButton("Zurück zum Menü");
        backBtn.setBackground(Color.YELLOW);
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(e -> frame.showMenu());
        add(backBtn, BorderLayout.SOUTH);

        blocks = new ArrayList<>();
        blocks.add(new CreditBlock("Joshua", 0));
        blocks.add(new CreditBlock("Über mich: Ich programmiere gerne Spiele.", 5));
        blocks.add(new CreditBlock("Meine Lieblingssprache: Java.", 10));
        blocks.add(new CreditBlock("Zukunft: Game Developer werden.", 25));

        updateUnlockedBlocks(0);
    }


    public void updateUnlockedBlocks(int totalScore) {
        contentPanel.removeAll();
        blocks.forEach(block -> {
            if (totalScore >= block.requiredScore) {
                JLabel label = new JLabel(block.text);
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                contentPanel.add(label);
            } else {
                JLabel locked = new JLabel("[Block gesperrt – benötigt " + block.requiredScore + " Punkte]");
                locked.setForeground(Color.GRAY);
                locked.setFont(new Font("Arial", Font.ITALIC, 16));
                locked.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                contentPanel.add(locked);
            }
        });
        revalidate();
        repaint();
    }

    private static class CreditBlock {
        String text;
        int requiredScore;

        public CreditBlock(String text, int requiredScore) {
            this.text = text;
            this.requiredScore = requiredScore;
        }
    }
}
