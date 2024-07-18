package hackerRank_Algorithms.Easy.TaumAndBDay;

public class Solution {
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // 计算直接购买的成本
        long originalCost = (long) b * bc + (long) w * wc;

        // 如果转换成本小于差价，则考虑转换
        long costIfConvertBlackToWhite = (long) b * (wc + z) + (long) w * wc;
        long costIfConvertWhiteToBlack = (long) w * (bc + z) + (long) b * bc;

        // 返回最小的成本
        return Math.min(originalCost, Math.min(costIfConvertBlackToWhite, costIfConvertWhiteToBlack));
    }


    public static void main(String[] args) {
        taumBday(27984 ,1402, 619246 ,615589 ,247954);
    }
}
