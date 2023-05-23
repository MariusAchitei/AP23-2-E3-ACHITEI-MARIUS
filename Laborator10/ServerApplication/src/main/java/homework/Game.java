package org.example;

class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private boolean started;

    public Game() {
        board = new Board();
        players = new Player[2];
        currentPlayerIndex = 0;
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void addPlayer(Player player) {
        if (!started) {
            players[currentPlayerIndex] = player;
            currentPlayerIndex++;
            if (currentPlayerIndex == 2) {
                started = true;
                System.out.println("Game started!");
            }
        }
    }

    public boolean makeMove(String move) {
        if (started) {
            Player currentPlayer = players[currentPlayerIndex];
            boolean validMove = board.placePiece(move, currentPlayer.getPiece());
            if (
                    validMove) {
                System.out.println(currentPlayer.getName() + " made a move: " + move);
                board.printBoard();
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
            }
            return validMove;
        }
        return false;
    }
}