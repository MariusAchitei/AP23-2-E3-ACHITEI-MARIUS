package org.example;

public class Player {
    private String name;
    private char piece;
    public Player(String name) {
        this.name = name;
        this.piece = name.charAt(0);
    }

    public String getName() {
        return name;
    }

    public char getPiece() {
        return piece;
    }

}
