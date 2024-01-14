package leetcode.easy.Q119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution_DP {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);

        //初始化第一个元素，每一行第一个都是1
        row.add(1);

        //逐行遍历，因为已经加过1了，所以从i=1开始
        for (int i = 1; i < rowIndex + 1; i++) {
            //杨辉三角形特性是每一个数的值是其正上方和左上方的数相加
            //此时每行一定要从后向前遍历，因为我实际上在一行上面去更新，
            //由于每个值是其左上和 正上方相加，正向遍历会覆盖掉左上的值，而反向则会避免此问题
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            //不要忘了结尾还要加上1
            row.add(1);
        }
        return row;
    }

    /**
     * Comment:
     * 动态规划
     * 我觉得比较要注意的是遍历时候的边界定义
     * 因为我们第一个值和最后一个值是手动定义为1的
     * 需要举个例子开检查下i和j的边界
     */
}
