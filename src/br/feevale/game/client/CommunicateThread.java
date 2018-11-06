package br.feevale.game.client;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CommunicateThread extends Thread {

    BufferedReader reader;
    Socket socket;

    public CommunicateThread(Socket s) {
        this.socket = s;
    }

    public void communicate() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String receive;
            while ((receive = receive()) != null) {
                System.out.println("run()" + receive);
                if ("keyReleased".equals(receive)) {
                    GamePanel.keyDown = false;
                    GamePanel.keyUp = false;
                    GamePanel.keyLeft = false;
                    GamePanel.keyRight = false;
                } else if (isKeyPressDown(Integer.valueOf(receive))) {
                    GamePanel.keyDown = true;
                    GamePanel.keyUp = false;
                    GamePanel.keyLeft = false;
                    GamePanel.keyRight = false;
                } else if (isKeyPressUp(Integer.valueOf(receive))) {
                    GamePanel.keyDown = false;
                    GamePanel.keyUp = true;
                    GamePanel.keyLeft = false;
                    GamePanel.keyRight = false;
                } else if (isKeyPressLeft(Integer.valueOf(receive))) {
                    GamePanel.keyDown = false;
                    GamePanel.keyUp = false;
                    GamePanel.keyLeft = true;
                    GamePanel.keyRight = false;
                } else if (isKeyPressRight(Integer.valueOf(receive))) {
                    GamePanel.keyDown = false;
                    GamePanel.keyUp = false;
                    GamePanel.keyLeft = false;
                    GamePanel.keyRight = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String receive() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isKeyPressUp(int keyCode) {
        return keyCode == KeyEvent.VK_UP;
    }

    private boolean isKeyPressDown(int keyCode) {
        return keyCode == KeyEvent.VK_DOWN;
    }

    private boolean isKeyPressLeft(int keyCode) {
        return keyCode == KeyEvent.VK_LEFT;
    }

    private boolean isKeyPressRight(int keyCode) {
        return keyCode == KeyEvent.VK_RIGHT;
    }

}
