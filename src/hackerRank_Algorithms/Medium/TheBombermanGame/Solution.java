package hackerRank_Algorithms.Medium.TheBombermanGame;

import java.util.*;

public class Solution {

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) {
            return grid;
        }

        int rows = grid.size();
        int cols = grid.get(0).length();

        if (n % 2 == 0) {
            return fullBombGrid(rows, cols);
        } else {
            List<String> afterFirstExplosion = simulateExplosion(grid);

            if (n % 4 == 3) {
                return afterFirstExplosion;
            } else {
                return simulateExplosion(afterFirstExplosion);
            }
        }
    }

    private static List<String> fullBombGrid(int rows, int cols) {
        List<String> fullGrid = new ArrayList<>();
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            row.append('O');
        }
        String fullRow = row.toString();
        for (int i = 0; i < rows; i++) {
            fullGrid.add(fullRow);
        }
        return fullGrid;
    }

    private static List<String> simulateExplosion(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] newGrid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newGrid[i][j] = 'O';
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    newGrid[i][j] = '.';
                    if (i > 0) newGrid[i - 1][j] = '.';
                    if (i < rows - 1) newGrid[i + 1][j] = '.';
                    if (j > 0) newGrid[i][j - 1] = '.';
                    if (j < cols - 1) newGrid[i][j + 1] = '.';
                }
            }
        }

        List<String> resultGrid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            resultGrid.add(new String(newGrid[i]));
        }
        return resultGrid;
    }
}

