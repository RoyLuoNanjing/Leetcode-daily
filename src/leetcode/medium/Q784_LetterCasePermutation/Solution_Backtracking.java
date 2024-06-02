package leetcode.medium.Q784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution_Backtracking {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder l = new StringBuilder();

        backtracking(res, l, s, 0);
        return res;
    }


    private void backtracking(List<String> res, StringBuilder current, String s, int index) {
        // 当路径长度等于输入字符串长度时，将当前路径存入结果集
        if (index == s.length()) {
            res.add(current.toString());
            return;
        }

        char ch = s.charAt(index);

        // 如果是数字，直接添加
        if (Character.isDigit(ch)) {
            current.append(ch);
            backtracking(res, current, s, index + 1);
            current.deleteCharAt(current.length() - 1);
        } else {
            // 小写字符递归
            current.append(Character.toLowerCase(ch));
            backtracking(res, current, s, index + 1);
            current.deleteCharAt(current.length() - 1);

            // 大写字符递归
            current.append(Character.toUpperCase(ch));
            backtracking(res, current, s, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * Comment:
     * 第一直觉我会用for循环
     * 但是后来发现有性能问题
     *
     * 此外回溯中if else只有一种情况会被考虑
     */
}
