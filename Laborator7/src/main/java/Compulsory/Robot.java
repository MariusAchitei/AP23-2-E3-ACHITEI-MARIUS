package Compulsory;

import java.util.Random;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    private Exploration explore;
    private Position position;

    public Robot(String name) {
        this.name = name;
    }

    public Exploration getExplore() {
        return explore;
    }

    public void setExplore(Exploration explore) {
        Random rand = new Random();
        this.explore = explore;
        int row = rand.nextInt(explore.getSize() - 1);
        int column = rand.nextInt(explore.getSize() - 1);
        position = new Position(row, column);
    }

    public void run() {
        int row;
        int column;
        Random rand = new Random();
        running = true;
        while (running) {
//        for (int i = 0; i < 10; i++) {
            row = position.row + rand.nextInt(2) - 1;
            column = position.column + rand.nextInt(2) - 1;
            if (row == position.row && column == position.column) continue;
            if (row < 0 || column < 0 || row >= explore.getSize() || column >= explore.getSize()) continue;

            System.out.println("Din clasa: " + name + " viziteaza celula:" + row + " " + column);
            explore.getMap().visit(row, column, this);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        }
    }

    public String getName() {
        return name;
    }
}
