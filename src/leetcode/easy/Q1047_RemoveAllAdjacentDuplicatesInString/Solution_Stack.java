package leetcode.easy.Q1047_RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

public class Solution_Stack {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()){
                char top = stack.peek();
                if (top == s.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        //StringBuffer可以用来存放char
        StringBuffer sb = new StringBuffer();
        for(char i : stack){
            sb.append(i);
        }
        return sb.toString();
    }
    /**
     * Comment:
     * Stack先进后出的原则进行消消乐
     */
}
