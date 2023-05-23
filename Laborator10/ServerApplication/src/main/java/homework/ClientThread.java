package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket;
    private Game game;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request = in.readLine();
            String response;

            if (request.equals("create game")) {
                if (game == null) {
                    game = new Game();
                    response = "Game created";
                } else {
                    response = "A game is already in progress";
                }
            } else if (request.startsWith("join game")) {
                if (game != null && !game.isStarted()) {
                    String playerName = request.substring(10);
                    Player player = new Player(playerName);
                    game.addPlayer(player);
                    response = "Player " + playerName + " joined the game";
                } else {
                    response = "No game available to join";
                }
            } else if (request.startsWith("submit move")) {
                if (game != null && game.isStarted()) {
                    String move = request.substring(12);
                    boolean validMove = game.makeMove(move);
                    if (validMove) {
                        response = "Move submitted";
                    } else {
                        response = "Invalid move";
                    }
                } else {
                    response = "No game in progress";
                }
            } else if (request.equals("stop")) {
                response = "Server stopped";
                GameServer.stop();
            } else if (request.equals("exit")) {
                response = "You disconnected!";
            } else {
                response = "Invalid command";
            }

            out.println(response);
        } catch (IOException e) {
            System.err.println("Communication error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}