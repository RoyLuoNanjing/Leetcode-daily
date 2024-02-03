package leetcode.easy.Q1071_GreatestCommonDivisorOfStrings;

public class Solution_Math {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        //关键点是把两个字符串首尾个拼接一块，如果不相等则没有公共后缀
        if (!(str1 + str2).equals(str2 + str1)) return "";

        //获取最大公约数
        int gcd = gcd(l1, l2);

        return str1.substring(0, gcd);
    }

    /**
     * 获取最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;

        }
        return a;
    }
    /**
     * Comment:
     * 前后拼接做判断
     * 最大公约数处理重复情况
     * 想不出来，真的想不出来
     */
}
