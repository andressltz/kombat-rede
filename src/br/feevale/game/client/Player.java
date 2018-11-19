package br.feevale.game.client;

import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {

    private static final String CHARACTER_IMAGE_RIGHT = "pers_right.gif";
    private static final String CHARACTER_IMAGE_RIGHT_ATTACK = "pers_right_attack.gif";
    private static final String CHARACTER_IMAGE_RIGHT_ATTACKED = "pers_right_attacked.gif";
    private static final String CHARACTER_IMAGE_LEFT = "pers_left.gif";
    private static final String CHARACTER_IMAGE_LEFT_ATTACK = "pers_left_attack.gif";
    private static final String CHARACTER_IMAGE_LEFT_ATTACKED = "pers_left_attacked.gif";

    private static final int CHARACTER_NORMAL_SIZE_WIDTH = 60;
    private static final int CHARACTER_NORMAL_SIZE_HEIGHT = 90;

    public int x = 0;
    public int y = 0;
    public int state = 0;
    private ImageIcon characterNR;
    private ImageIcon characterNL;
    private ImageIcon characterAR;
    private ImageIcon characterAL;
    private ImageIcon characterLR;
    private ImageIcon characterLL;
    private String playerName;

    public Player() {
        super(" ", new ImageIcon(), SwingConstants.RIGHT);
    }

    public void setup(int x, int y) {
        characterNR = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_RIGHT)).getImage().getScaledInstance(CHARACTER_NORMAL_SIZE_WIDTH, CHARACTER_NORMAL_SIZE_HEIGHT, Image.SCALE_DEFAULT));
        characterNL = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_LEFT)).getImage().getScaledInstance(CHARACTER_NORMAL_SIZE_WIDTH, CHARACTER_NORMAL_SIZE_HEIGHT, Image.SCALE_DEFAULT));
        characterAR = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_RIGHT_ATTACK)).getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT));
        characterAL = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_LEFT_ATTACK)).getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT));
        characterLR = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_RIGHT_ATTACKED)).getImage().getScaledInstance(CHARACTER_NORMAL_SIZE_WIDTH, CHARACTER_NORMAL_SIZE_HEIGHT, Image.SCALE_DEFAULT));
        characterLL = new ImageIcon(new ImageIcon(getClass().getResource(CHARACTER_IMAGE_LEFT_ATTACKED)).getImage().getScaledInstance(CHARACTER_NORMAL_SIZE_WIDTH, CHARACTER_NORMAL_SIZE_HEIGHT, Image.SCALE_DEFAULT));
        setBounds(x, y, 110, 127);
        setIcon(characterNR);
    }

    public void move() {
        setBounds(x, y, 110, 127);
        if (state == 0) {
            setIcon(characterNR);
        } else if (state == 1) {
            setIcon(characterNL);
        } else if (state == 2) {
            setIcon(characterAR);
        } else if (state == 3) {
            setIcon(characterAL);
        } else if (state == 4) {
            setIcon(characterLR);
        } else if (state == 5) {
            setIcon(characterLL);
        }
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        setText(playerName);
        updateUI();
    }

}
