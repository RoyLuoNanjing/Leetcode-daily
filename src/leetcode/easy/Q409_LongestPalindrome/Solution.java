package leetcode.easy.Q409_LongestPalindrome;

import java.util.HashMap;

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean hasOdd = false;
        int count = 0;
        for (int num : map.values()) {
            if (num % 2 == 0) {
                count += num;
            } else {
               hasOdd = true; //存在至少一个奇数
               count += num - 1; //使用奇数字符的最大偶数部分
            }
        }

        //如果存在奇数则中间可以放一个字符，不存在则不放
        return hasOdd? count + 1 : count;
    }

    /**
     * Comment:
     * 思路在于如果char是偶数则数量就全考虑
     * 如果char为奇数，则需要每次－1取其偶数部分
     * 在存在奇数的情况下，最后会有一个奇数被采用
     */
}
