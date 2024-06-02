package leetcode.medium.Q189_RotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 处理 k 大于数组长度的情况

        int count = 0; // 记录已经移动的元素数量
        int start = 0; // 起始位置

        while (count < n) { // 只要还有元素未移动完就继续
            int current = start; // 当前位置
            int prev = nums[start]; // 当前位置的值作为临时变量保存

            do {
                int next = (current + k) % n; // 计算下一个位置
                int temp = nums[next]; // 保存下一个位置的值
                nums[next] = prev; // 将当前位置的值放到下一个位置
                prev = temp; // 更新临时变量
                current = next; // 更新当前位置
                count++; // 更新已经移动的元素数量
            } while (start != current); // 当回到起始位置时停止循环

            start++; // 更新起始位置，准备处理下一个环
        }
    }

    /**
     * Comment:
     * 感觉不容易
     * 主要是没有想到如何处理重复的循环，
     *      有些情况下会出现循环回到起点的情况
     *      外循环不停的换起点来保证不会错过一些数
     * 保证空间复杂度为O（1）就要考虑数学
     */
}
