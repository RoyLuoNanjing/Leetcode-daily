package leetcode.medium.Q3148_MaximumDifferenceScoreInAGrid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_Brutal {
    public static int maxScore(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] arr = new int[m][n];

        arr[0][0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            arr[0][i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                arr[0][i] = Math.max(grid.get(0).get(i) - grid.get(0).get(j), arr[0][i]);
            }

        }

        for (int i = 1; i < m; i++) {
            arr[i][0] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                arr[i][0] = Math.max(grid.get(i).get(0) - grid.get(j).get(0), arr[i][0]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int fromLeft = Integer.MIN_VALUE;
                int fromUP = Integer.MIN_VALUE;
                for (int k = 0; k < j; k++) {
                    int difference = grid.get(i).get(j) - grid.get(i).get(k);
                    fromLeft = Math.max(difference, difference + arr[i][k]);
                }

                for (int k = 0; k < i; k++) {
                    int difference = grid.get(i).get(j) - grid.get(k).get(j);
                    fromUP = Math.max(difference, difference + arr[k][j]);
                }
                arr[i][j] = Math.max(fromLeft, fromUP);
            }
        }

        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxScore = Math.max(arr[i][j], maxScore);

            }
        }
        return maxScore;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]
                {{5,4,8,6,2}, {1,5,8,6,10},{8,6,9,2,10},{3,7,6,10,6}}
        ;

        // 将二维数组转换为 List<List<Integer>> 并传递给 maxScore 方法
        List<List<Integer>> list = Arrays.stream(arr)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        maxScore(list);
    }
}
