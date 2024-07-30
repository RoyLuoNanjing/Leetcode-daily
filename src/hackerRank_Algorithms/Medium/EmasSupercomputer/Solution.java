package hackerRank_Algorithms.Medium.EmasSupercomputer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static int twoPluses(List<String> grid) {
        int n = grid.size();
        int m = grid.get(0).length();
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];

        // Fill the up and left arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).charAt(j) == 'G') {
                    up[i][j] = (i == 0) ? 1 : up[i - 1][j] + 1;
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        // Fill the down and right arrays
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid.get(i).charAt(j) == 'G') {
                    down[i][j] = (i == n - 1) ? 1 : down[i + 1][j] + 1;
                    right[i][j] = (j == m - 1) ? 1 : right[i][j + 1] + 1;
                }
            }
        }

        List<int[]> pluses = new ArrayList<>();

        // Calculate maximum plus sizes and store all pluses
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).charAt(j) == 'G') {
                    int size = Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j]));
                    for (int k = 1; k <= size; k++) {
                        pluses.add(new int[]{i, j, k});
                    }
                }
            }
        }

        int maxProduct = 0;

        // Try all pairs of pluses
        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                int[] plus1 = pluses.get(i);
                int[] plus2 = pluses.get(j);
                if (!overlap(plus1, plus2)) {
                    int area1 = (4 * (plus1[2] - 1)) + 1;
                    int area2 = (4 * (plus2[2] - 1)) + 1;
                    maxProduct = Math.max(maxProduct, area1 * area2);
                }
            }
        }

        return maxProduct;
    }

    private static boolean overlap(int[] plus1, int[] plus2) {
        Set<String> cells = new HashSet<>();

        for (int i = 0; i < plus1[2]; i++) {
            cells.add((plus1[0] - i) + "," + plus1[1]);
            cells.add((plus1[0] + i) + "," + plus1[1]);
            cells.add(plus1[0] + "," + (plus1[1] - i));
            cells.add(plus1[0] + "," + (plus1[1] + i));
        }

        for (int i = 0; i < plus2[2]; i++) {
            if (cells.contains((plus2[0] - i) + "," + plus2[1]) ||
                    cells.contains((plus2[0] + i) + "," + plus2[1]) ||
                    cells.contains(plus2[0] + "," + (plus2[1] - i)) ||
                    cells.contains(plus2[0] + "," + (plus2[1] + i))) {
                return true;
            }
        }

        return false;
    }
}
