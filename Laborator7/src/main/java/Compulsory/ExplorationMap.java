package Compulsory;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;


    public ExplorationMap(int n) {

        this.matrix = new Cell[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = new Cell();
    }

    public synchronized boolean visit(int row, int column, Robot robot) {
        if (matrix[row][column].isVisited() == true)
            return false;
        Exploration exploration = robot.getExplore();
        List<Token> extracatedTokens = exploration.getMem().extractTokens(exploration.getSize());
        matrix[row][column].addTokens(extracatedTokens);
        System.out.println("Robot: " + robot.getName() + " viziteaza celula:" + row + " " + column);
        return true;
    }
//    @Override
//    public String toString() {
////        display the matrix;
//
//    }

}
