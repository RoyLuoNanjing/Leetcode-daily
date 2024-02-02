package leetcode.medium.Q739_DailyTemperatures;

import java.util.Stack;

public class Solution_Stack {
    public int[] dailyTemperatures(int[] temperatures) {
        //数组长度
        int n = temperatures.length;
        //初始化一个容器存放结果
        int[] result = new int[n];
        //使用栈来存储温度的索引，栈顶元素是当前还没有找到更高温度的天数索引
        Stack<Integer> stack = new Stack<>();


        //遍历温度数组
        for (int i = 0; i < n; i++) {
            //当栈不为空，且当前温度大于栈顶索引对应的温度时
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                //弹出栈顶元素，该元素对应的是之前的某天的索引
                int index = stack.pop();
                //计算当前天与之前某天的差值，即为之前那天之后出现更高温度的天数
                result[index] = i - index;
            }

            //将当前的索引入栈，等待后续天数的温度与它比较
            stack.push(i);
        }
        //对于栈中剩余的索引，它们之后没有更高的温度，所以结果数组中对应的值默认为0，不需要额外操作
        //因为int数组的初始化会让所有的值变成0
        return result;
    }

    /**
     * Comment:
     * 巧用stack
     * 我觉得关键点应该是遍历时候的while循环，将之前每个没有结果但是满足条件的索引都给排除出去并记录下相差的时间
     */
}
