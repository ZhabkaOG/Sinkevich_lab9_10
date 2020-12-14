package mirea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame extends javax.swing.JFrame {
    int Team1Score = 0, Team2Score = 0;
    JButton Team1 = new JButton();
    ImageIcon Team1Icon =
            new ImageIcon((new ImageIcon("image/juventus.png").getImage()
                    .getScaledInstance(200, 300, Image.SCALE_SMOOTH)));
    JButton Team2 = new JButton();
    ImageIcon Team2Icon =
            new ImageIcon(new ImageIcon("image/realmadrid.png").getImage()
                    .getScaledInstance(200, 300, Image.SCALE_SMOOTH));
    JLabel result = new JLabel("Result: 0 X 0");
    JLabel lastScore = new JLabel("N/A");
    JLabel winner = new JLabel("Winner: DRAW");
    JLabel Team1Team = new JLabel("Team №1");
    Font fnt = new Font("Times New Roman", Font.BOLD, 30);
    // Метод для обработки информации о победителе
    public void printWinner() {
        if (Team1Score > Team2Score) {
            winner.setText("Winner: Team №1");
        } else if (Team1Score < Team2Score) {
            winner.setText("Winner: Team №2");
        } else {
            winner.setText("DRAW");
        }
    }
    // Метод для обработки полей счета, победителя и последнего забившего
    public void JLabelSettings(JLabel jlabel) {
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        jlabel.setForeground(Color.PINK);
        jlabel.setFont(fnt);
    }
    // Метод обработки кнопок команд
    public void teamButton(JButton team, String teamName, Color color) {
        team.setText(teamName);
        team.setVerticalTextPosition(JButton.BOTTOM);
        team.setHorizontalTextPosition(JButton.CENTER);
        team.setForeground(color);
        team.setFont(fnt);
    }
    JFrame() {
// Параметры окна
        super("Football Score");
        setIconImage(new ImageIcon("image/appIcon.jpg").getImage());
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(900, 500));
        Team1.setIcon(Team1Icon);
        Team1.setFocusable(false);
        Team1.setBorderPainted(false);
        Team2.setIcon(Team2Icon);
        Team2.setFocusable(false);
        Team2.setBorderPainted(false);
// Обработка AC Milan
        add(Team1, BorderLayout.EAST);
        ActionListener ACMilanListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Team1Score++;
                result.setText("Result: " + Team2Score + " X " + Team1Score);
                printWinner();
                lastScore.setText("Last score: Team №1");
            }
        };
        teamButton(Team1, "Team №1", Color.BLUE);
        Team1.addActionListener(ACMilanListener);
// Обработка Real Madrid
        add(Team2, BorderLayout.WEST);
        ActionListener RealMadridListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Team2Score++;
                result.setText("Result: " + Team2Score + " X " + Team1Score);
                printWinner();
                lastScore.setText("Last score: Team №2");
            }
        };
        teamButton(Team2, "Team №2", Color.DARK_GRAY);
        Team2.addActionListener(RealMadridListener);
// Обработка счета
        add(result, BorderLayout.CENTER);
        JLabelSettings(result);
// Обработка победителя
        add(winner, BorderLayout.NORTH);
        JLabelSettings(winner);
// Обработка последнего забившего
        add(lastScore, BorderLayout.SOUTH);
        JLabelSettings(lastScore);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JFrame();
    }
}