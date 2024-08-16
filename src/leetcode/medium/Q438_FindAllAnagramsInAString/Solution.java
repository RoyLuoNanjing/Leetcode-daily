package leetcode.medium.Q438_FindAllAnagramsInAString;

import java.util.*;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        int windowLength = p.length();

        for (int i = 0; i < windowLength; i++) {
            windowMap.put(p.charAt(i), windowMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        if (p.length() > s.length()) return res;
        for (int i = 0; i < windowLength; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (map.equals(windowMap)) {
            res.add(0);
        }
        System.out.println(map);
        System.out.println(windowMap);

        for (int i = 1; i < s.length() - windowLength + 1; i++) {
            map.put(s.charAt(i - 1), map.get(s.charAt(i - 1)) - 1);
            map.put(s.charAt(i + windowLength - 1), map.getOrDefault(s.charAt(i + windowLength - 1), 0) + 1);

            map.entrySet().removeIf(entry -> entry.getValue() == 0);

            System.out.println(map);

            if (map.equals(windowMap)) {
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        findAnagrams(s, p);
    }
}
