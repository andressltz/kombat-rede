package br.feevale.game.client;

import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {

    private static final String CHARACTER_IMAGE = "pers1.gif";
    private static final String CHARACTER_IMAGE_ATTACK = "pers2.gif";

    public int x = 0;
    public int y = 0;
    private ImageIcon walkR;
    private String playerName;
    public int state = 0;

    public Player() {
        super(" ", new ImageIcon(), SwingConstants.RIGHT);
    }

    public void setup(int x, int y) {
        walkR = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE)).getImage().getScaledInstance(88, 120, Image.SCALE_DEFAULT));
        setBounds(x, y, 110, 127);
        setIcon(walkR);
    }

    public void move() {
        setBounds(x, y, 110, 127);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        setText(playerName);
        updateUI();
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void attack() {
        walkR.setImage(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_ATTACK)).getImage().getScaledInstance(88, 120, Image.SCALE_DEFAULT));
        updateUI();
    }

    public void normal() {
        walkR.setImage(new ImageIcon(getClass().getResource(CHARACTER_IMAGE)).getImage().getScaledInstance(88, 120, Image.SCALE_DEFAULT));
        updateUI();
    }
}
