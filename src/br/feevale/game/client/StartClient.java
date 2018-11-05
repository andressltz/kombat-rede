//package br.feevale.game.client;
//
//import javax.swing.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class StartClient extends Thread {
//
//    private static final int SERVER_PORT = 8181;
//    private static final String SERVER_HOST = "localhost";
//
//    private PrintWriter writer;
//
//    private static Socket socket;
//    static GamePanel game;
//
////    public static void main(String[] args) {
////        StartClient client = new StartClient();
////        client.connect();
////        game = new GamePanel();
////        game.startGame();
//////        GamePanel.startGame();
////        client.start();
////
////        while(true) {
////            client.communicate();
////        }
////
////    }
//
////    private void connect() {
////        try {
////            socket = new Socket(SERVER_HOST, SERVER_PORT);
////            writer = new PrintWriter(socket.getOutputStream());
////        } catch (IOException e) {
////            e.printStackTrace();
////            JOptionPane.showMessageDialog(null, "Erro ao conectar com o servidor: " + e.getLocalizedMessage());
////        }
////    }
//
////    private void communicate() {
////        if (game.isKeyPressed) {
////            System.out.println("Apertei a tecla " + game.keyPressed);
////            writer.println(game.keyPressed);
////            writer.flush();
////            game.isKeyPressed = false;
////        }
////    }
//
//
//}
