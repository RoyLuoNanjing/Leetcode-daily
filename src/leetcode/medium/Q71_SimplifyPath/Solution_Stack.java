package leetcode.medium.Q71_SimplifyPath;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Stack {
    public String simplifyPath(String path) {
        //将给定的字符串根据/分割成列表
        String[] names = path.split("/");

        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            //如果是..即表示返回，要将上一个stack存储的file去除
            if ("..".equals(name)) {
                stack.pollLast();
            }
            //如果是空则忽略（比如是//的情况）
            //如果是.的话，则表示当前目录本身，我们也可以直接忽略
            else if (!name.isEmpty() && !".".equals(name)) {
                stack.offerLast(name);
            }
        }

        StringBuffer ans = new StringBuffer();
        //如果啥都没有的话，就是根目录，即为/
        if (stack.isEmpty()) {
            ans.append("/");
        } else {
            //遍历存值
            while (!stack.isEmpty()) {
                ans.append("/");
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    /**
     * COMMENTS:
     * deque双端队列会更效率
     * deque和链表都可以用来做队列和栈
     * 主要取决于调用方法做到先进先出还是后进先出
     * 题目不难主要还是在对题意的理解和分析
     */
}
