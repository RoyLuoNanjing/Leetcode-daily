package leetcode.easy.Q232_ImplementQueueUsingStacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Deque {
    class MyQueue {
        Deque<Integer> stack;

        public MyQueue() {
            stack = new ArrayDeque<>();

        }

        public void push(int x) {
            stack.offerLast(x);
        }

        public int pop() {
            return stack.removeFirst();
        }

        public int peek() {
            return stack.peekFirst();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

    /**
     * Comment:
     * 不是很有意思，题目说是用两个stacks来表示，但是标准答案用了两个deque
     * 而处理这种问题，一个deque就行了
     * 如果非要两个stacks，实际原理就是在另一个stack中pop和peek
     */

}
