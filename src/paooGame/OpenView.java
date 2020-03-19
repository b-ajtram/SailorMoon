package paooGame;

import GameEnums.Level;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenView extends JPanel implements ActionListener {
    public static boolean isRunning = true;
    public static Level level=Level.LEVEL1;
    public static String characterName="Sailor Moon";
    public static int health=500;
    public static int score=0;


    BackgroundLoader backgroundLoader = BackgroundLoader.getInstance(Map.BOARD_WIDTH, Map.BOARD_HEIGHT);
    JButton startButton;
    JButton loadButton;
    JComboBox<String> selectPlayer;
    private void drawObjects(Graphics g) {
        g.drawImage(backgroundLoader.getOpenBackground(), 0, 0, this);
    }

    public OpenView() {
        isRunning=false;
        startButton = new JButton("New Game");
        startButton.setBackground(Color.PINK);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning=true;
                characterName=selectPlayer.getSelectedItem().toString();
                level=Level.LEVEL1;
            }
        });
        String[] branches = {"Sailor Moon", "Sailor Mars", "Sailor Mercury", "Sailor Venus", "Sailor Jupiter"};
        selectPlayer = new JComboBox<String>(branches);
        selectPlayer.setBackground(Color.PINK);

        loadButton = new JButton("Load Game");
        loadButton.setBackground(Color.PINK);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(loadButton);
        add(startButton);
        add(selectPlayer);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 100, 330));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
