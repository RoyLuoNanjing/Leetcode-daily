package leetcode.challenges.BNP.Challenge2;

import java.util.List;

public class Solution {

    public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
        // 初始化两位玩家的得分
        int andreaScore = 0;
        int mariaScore = 0;

        // 确定从哪个索引开始 (如果是 "Even"，从 0 开始；如果是 "Odd"，从 1 开始)
        int startIndex = s.equals("Even") ? 0 : 1;

        // 遍历所有符合条件的卡牌
        for (int i = startIndex; i < andrea.size(); i += 2) {
            // 更新 Andrea 的得分
            andreaScore += andrea.get(i) - maria.get(i);
            // 更新 Maria 的得分
            mariaScore += maria.get(i) - andrea.get(i);
        }

        // 比较最终的分数并返回结果
        if (andreaScore > mariaScore) {
            return "Andrea";
        } else if (mariaScore > andreaScore) {
            return "Maria";
        } else {
            return "Tie";
        }
    }
}
