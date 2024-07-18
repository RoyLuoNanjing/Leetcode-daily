package hackerRank_DataStructures.Easy.DynamicArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // 初始化包含N个空序列的列表
        List<List<Integer>> sequences = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            sequences.add(new ArrayList<>());
        }

        // 初始化结果列表，用于存储所有类型2查询的结果
        List<Integer> result = new ArrayList<>();
        // 初始化 lastAnswer 为 0
        int lastAnswer = 0;

        // 遍历所有查询
        for (List<Integer> query : queries) {
            // 获取查询的类型、x 和 y
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            // 计算序列的索引
            int seqIndex = (x ^ lastAnswer) % n;
            // 获取对应索引的序列
            List<Integer> seq = sequences.get(seqIndex);

            if (queryType == 1) {
                // 类型1查询：向序列中添加 y
                seq.add(y);
            } else if (queryType == 2) {
                // 类型2查询：从序列中获取元素，更新 lastAnswer 并添加到结果列表中
                lastAnswer = seq.get(y % seq.size());
                result.add(lastAnswer);
            }
        }

        // 返回所有类型2查询的结果列表
        return result;
    }
}
