package leetcode.easy.Q20_ValidParentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_Stack {
    private static final Map<Character,Character> map = new HashMap<>(){
        {
            put('(',')');
            put('{','}');
            put('[',']');

        }
    };


    public boolean isValid(String s) {
        if(!s.isEmpty() && !map.containsKey(s.charAt(0)))return false;
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.addLast(c);
            } else if ( !stack.isEmpty() && c==map.get(stack.getLast()) ){
                stack.removeLast();   //如果与此时stack中最后一个配对则移除stack最后一个
            } else return false;
        }
        return stack.isEmpty();
    }

    /**
     * COMMENTS:
     * 利用stack先进后出的特点来进行消消乐
     * map将键值对存好用于配对
     * 链表可以模拟stack
     * 如果都属于左括号就往链表里面加，如果右括号则需要看是否配对，不配对则false
     */
}
