package hackerRank_Algorithms.Easy.FairRations;

import java.util.List;

public class Solution {
    public static String fairRations(List<Integer> B) {
        int count = 0;

        // 遍历面包数量列表
        for (int i = 0; i < B.size() - 1; i++) {
            // 如果当前面包数量是奇数
            if (B.get(i) % 2 != 0) {
                // 给当前人和下一个人各加一个面包
                B.set(i, B.get(i) + 1);
                B.set(i + 1, B.get(i + 1) + 1);
                // 计数增加2，因为我们总共发了两个面包
                count += 2;
            }
        }

        // 检查最后一个人的面包数量是否是偶数
        if (B.get(B.size() - 1) % 2 != 0) {
            return "NO";
        }

        // 返回总共发放的面包数量
        return String.valueOf(count);
    }
}
