package hackerRank_Algorithms.Easy.CaesarCipher;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String caesarCipher(String s, int k) {
        // Write your code here
        String originalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int l = originalAlphabet.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int matchIndex = (i + k) % l;
            map.put(originalAlphabet.charAt(i), originalAlphabet.charAt(matchIndex));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            boolean isUpperCase = Character.isUpperCase(target);
            if (isUpperCase) {
                target = Character.toLowerCase(target);
            }

            char c;
            if (map.get(target) != null) {
                c = map.get(target);
                if (isUpperCase) {
                    c = Character.toUpperCase(c);
                }
            } else {
                c = target;
            }


            sb.append(c);
        }

        return sb.toString();
    }
}
