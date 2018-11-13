package br.feevale.game.client;

import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {

    private static final String CHARACTER_IMAGE = "character.gif";

    public int x = 0;
    public int y = 0;
    private ImageIcon walkR;
    private String playerName;


    public Player() {
        super(" ", new ImageIcon(), SwingConstants.RIGHT);
    }

    public void setup() {
        walkR = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE)).getImage().getScaledInstance(88, 127, Image.SCALE_DEFAULT));
        setBounds(x, y, 110, 127);
        setIcon(walkR);
    }

    public void move() {
        setBounds(x, y, 110, 127);
    }

    public void setPlayerName(String playerName) {
        System.out.println("setou " + playerName);
        this.playerName = playerName;
        setText(playerName);
        updateUI();
    }

    public String getPlayerName() {
        return this.playerName;
    }

}
