package leetcode.challenges.JPMorganChase.QuestionTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.*;

public class Solution {

    private static List<Integer> noRepeatNumbers; // 用于存储所有不含重复数字的数字列表

    // 计算并输出每个范围内不含重复数字的个数
    public static void countNumbers(List<List<Integer>> arr) {
        // 预先生成一百万以内所有无重复数字的列表
        precomputeNoRepeatNumbers(1000000);
        arr.forEach(list -> {
            System.out.println(countNumberOfOneList(list));
        });
    }

    // 预先计算一定范围内所有不含重复数字的数字
    public static void precomputeNoRepeatNumbers(int limit) {
        noRepeatNumbers = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            if (!hasRepeatedDigits(i)) { // 如果数字没有重复的数字
                noRepeatNumbers.add(i); // 添加到列表中
            }
        }
    }

    // 计算指定范围内不含重复数字的个数
    public static int countNumberOfOneList(List<Integer> arr) {
        int lower = arr.get(0); // 范围的下界
        int upper = arr.get(1); // 范围的上界

        // 使用二分查找定位下界和上界
        int lowerIndex = Collections.binarySearch(noRepeatNumbers, lower);
        int upperIndex = Collections.binarySearch(noRepeatNumbers, upper);

        // 如果未找到精确值，调整索引以找到合适的插入点
        if (lowerIndex < 0) lowerIndex = -lowerIndex - 1;
        if (upperIndex < 0) upperIndex = -upperIndex - 2;

        // 计算范围内不含重复数字的个数
        return upperIndex - lowerIndex + 1;
    }

    // 判断一个数字是否有重复的数字
    public static boolean hasRepeatedDigits(int number) {
        boolean[] digitSeen = new boolean[10]; // 用于记录每个数字是否出现过
        while (number > 0) {
            int digit = number % 10; // 取出最后一位数字
            if (digitSeen[digit]) { // 如果该数字已经出现过
                return true; // 有重复数字
            }
            digitSeen[digit] = true; // 标记该数字已经出现
            number /= 10; // 去掉最后一位数字
        }
        return false; // 无重复数字
    }

    public static void main(String[] args) {
        // 示例输入
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1, 20),
                Arrays.asList(10, 100),
                Arrays.asList(100, 200)
        );

        // 输出每个范围内无重复数字的个数
        countNumbers(arr); // 预期输出: 19, 81, 89
    }
}
