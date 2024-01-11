package leetcode.medium.Q227_BasicCalculatorII;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Stack {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //因为可能是大于10的数字进行运算，所以需要判断是几位数字
            //如果是数字,则需要判断是几位数字，用num来记录数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0'; //char 统一减去‘0’来转换为int并靠*10来运算是几位数字
            }

            //如果不是数字，则将正在计算的值压入栈中
            //还要判断是不是空格 或 这运算符号恰好是最后一位的情况
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);

                    //如果是乘法则把栈中最上面的数拿出来运算并替换
                    case '*' -> stack.push(stack.pop() * num);

                    //反之亦然
                    default -> stack.push(stack.pop() / num);
                }
                //将之前的符号给重置
                preSign = s.charAt(i);
                //重置积累的数以便获取多位数
                num = 0;
            }

        }
        //遍历栈里面的正负数
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    /**
     * COMMENTS:
     * 巧妙运用deque来建立栈
     * 前面是+或-则直接压入栈
     * 前面是*或/则将栈顶层拿出来做运算再放回去
     * 注意有可能是大于10的数，所以要用num来单独记录
     */
}

