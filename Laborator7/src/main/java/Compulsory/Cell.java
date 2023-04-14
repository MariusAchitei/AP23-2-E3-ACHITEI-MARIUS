package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokens;
    private boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void addTokens(List<Token> extractedTokens) {
        tokens = extractedTokens;
        visited = true;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Cell() {
    }

    public Cell(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
