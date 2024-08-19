package leetcode.medium.Q394_DecodeString;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder original = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String current = Character.toString(s.charAt(i));
            if (current.equals("]")) {
                // Step 1: Pop all characters until we find '['
                original.setLength(0);
                while (!stack.peek().equals("[")) {
                    original.insert(0, stack.pop());
                }
                stack.pop(); // 去除'['

                // Step 2: Collect the number before '['
                StringBuilder numBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    numBuilder.insert(0, stack.pop());
                }
                int head = Integer.parseInt(numBuilder.toString());

                // Step 3: Repeat the string `head` times and push back to stack
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < head; j++) {
                    temp.append(original);
                }
                stack.push(temp.toString());
            } else {
                stack.push(current);
            }
        }

        // Construct final result from stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

}
