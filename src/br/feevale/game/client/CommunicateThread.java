package br.feevale.game.client;

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
                System.out.println(receive);
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

}
