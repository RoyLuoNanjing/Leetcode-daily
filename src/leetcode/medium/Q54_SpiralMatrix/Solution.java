package leetcode.medium.Q54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //初始化容器装数据
        List<Integer> result = new ArrayList<>();

        //matrix 为空的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        //确定左右上下边界
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

        //循环终止的条件
        while (left <= right && top <= bottom) {
            //从左到右遍历
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //从上到下遍历
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //检查是有更多的行
            if (top <= bottom) {
                //从左到右遍历
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;

            //检查是否有更多的列
            if (left <= right) {
                //从下到上遍历
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    /**
     * COMMENTS:
     * 比较经典的问题，主要还是在对于边界条件的考虑
     * 主要考虑设置上下左右四个点，然后不停的循环，停止条件是上下边界并且左右边界相等
     * 中途要判断是否列和行都循环完毕
     */
}
