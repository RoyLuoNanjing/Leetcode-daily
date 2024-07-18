package hackerRank.Medium.OrganizingContainersOfBalls;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static String organizingContainers(List<List<Integer>> container) {
        int numOfContainers = container.size();
        int numOfColors = container.get(0).size();

        // 数组来存储每个容器中的球的总数
        long[] containerSum = new long[numOfContainers];
        // 数组来存储每种颜色的球的总数
        long[] colorSum = new long[numOfColors];

        // 计算每个容器的球的总数
        for (int i = 0; i < numOfContainers; i++) {
            for (int j = 0; j < numOfColors; j++) {
                long value = container.get(i).get(j);
                containerSum[i] += value;
                colorSum[j] += value;
            }
        }

        // 对两个数组进行排序
        Arrays.sort(containerSum);
        Arrays.sort(colorSum);

        // 比较两个数组，如果相等则返回 "Possible"，否则返回 "Impossible"
        for (int i = 0; i < numOfContainers; i++) {
            if (containerSum[i] != colorSum[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
