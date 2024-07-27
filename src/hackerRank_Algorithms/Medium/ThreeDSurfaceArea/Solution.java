package hackerRank_Algorithms.Medium.ThreeDSurfaceArea;

import java.util.List;

public class Solution {
    public static int surfaceArea(List<List<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        int totalArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int h = A.get(i).get(j);
                if (h > 0) {
                    totalArea += 2; // 顶部和底部

                    // 上面
                    totalArea += (i == 0) ? h : Math.max(h - A.get(i - 1).get(j), 0);

                    // 下面
                    totalArea += (i == rows - 1) ? h : Math.max(h - A.get(i + 1).get(j), 0);

                    // 左面
                    totalArea += (j == 0) ? h : Math.max(h - A.get(i).get(j - 1), 0);

                    // 右面
                    totalArea += (j == cols - 1) ? h : Math.max(h - A.get(i).get(j + 1), 0);
                }
            }
        }

        return totalArea;
    }
}


