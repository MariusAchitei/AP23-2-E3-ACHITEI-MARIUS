package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;
    static boolean isOn;
    static ServerSocket serverSocket = null ;
    public GameServer() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                isOn=true;
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void stop() {
        try {
            isOn = false;
            serverSocket.close();
        }catch (IOException e){
            System.err.println(e);
        }
    }
    public static void main ( String [] args ) throws IOException {
        GameServer server = new GameServer();
    }

}