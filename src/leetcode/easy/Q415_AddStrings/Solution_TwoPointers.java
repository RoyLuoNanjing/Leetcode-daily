package leetcode.easy.Q415_AddStrings;

public class Solution_TwoPointers {
    public String addStrings(String num1, String num2) {
        int pointerNum1 = num1.length() - 1;
        int pointerNum2 = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();

        while (pointerNum1 >= 0 || pointerNum2 >= 0 || add != 0) {
            //减去字符 '0' 是一种将字符（char）转换为对应整数（int）的常用方法，特别是在处理数字字符时。
            int first = pointerNum1 >= 0 ? num1.charAt(pointerNum1) - '0' : 0;
            int second = pointerNum2 >= 0 ? num2.charAt(pointerNum2) - '0' : 0;
            int result = first + second + add;

            ans.append(result % 10);
            add = result / 10;
            pointerNum1--;
            pointerNum2--;
        }
        ans.reverse();
        return ans.toString();
    }

    /**
     * Comment:
     * 这题的有趣之处在于不可以直接对string转int却可以对char转int
     * 用双指针从尾部往前移动对两个char进行相加
     * 最后的答案string要翻转一下
     *
     * 注意：如果两数长度不一样，可以继续让循环执行下去，只不过短的数一律为0即可
     * 如果两数长度一样但是最后时刻进1则可以通过add是否存在来进行继续循环
     *
     * 另外：例如，如果 num1 是 "123"，num1.charAt(0) 将会返回字符 '1'，而不是数字 1。
     * 在 ASCII 编码中，字符 '0' 到 '9' 分别对应着整数值 48 到 57。
     * 因此，要将字符 '1' 转换为数字 1，你需要从 '1' 的 ASCII 值中减去 '0' 的 ASCII 值，
     * 即 num1.charAt(0) - '0'（这里等于 49 - 48 = 1）。
     */
}
