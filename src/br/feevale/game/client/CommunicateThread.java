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
                if (receive.startsWith("name:")) {
                    GamePanel.playerName = receive.split(":")[1];
                }
                
                String clientName = receive.split(":")[0];
                String clientCommand = receive.split(":")[1];

                if (GamePanel.playerName.equals(clientName)) {
                    if ("keyReleased".equals(clientCommand)) {
                        GamePanel.keyDown = false;
                        GamePanel.keyUp = false;
                        GamePanel.keyLeft = false;
                        GamePanel.keyRight = false;
                    } else if (isKeyPressDown(Integer.valueOf(clientCommand))) {
                        GamePanel.keyDown = true;
                        GamePanel.keyUp = false;
                        GamePanel.keyLeft = false;
                        GamePanel.keyRight = false;
                    } else if (isKeyPressUp(Integer.valueOf(clientCommand))) {
                        GamePanel.keyDown = false;
                        GamePanel.keyUp = true;
                        GamePanel.keyLeft = false;
                        GamePanel.keyRight = false;
                    } else if (isKeyPressLeft(Integer.valueOf(clientCommand))) {
                        GamePanel.keyDown = false;
                        GamePanel.keyUp = false;
                        GamePanel.keyLeft = true;
                        GamePanel.keyRight = false;
                    } else if (isKeyPressRight(Integer.valueOf(clientCommand))) {
                        GamePanel.keyDown = false;
                        GamePanel.keyUp = false;
                        GamePanel.keyLeft = false;
                        GamePanel.keyRight = true;
                    }
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
