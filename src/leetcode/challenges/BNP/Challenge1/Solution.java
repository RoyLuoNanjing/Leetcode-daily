package leetcode.challenges.BNP.Challenge1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static String largestMagical(String binString) {
        List<String> goodSubstrings = new ArrayList<>();
        int balance = 0, start = 0;

        // Step 1: 分割好子串
        for (int i = 0; i < binString.length(); i++) {
            balance += binString.charAt(i) == '1' ? 1 : -1;
            if (balance == 0) {  // 一个好子串
                goodSubstrings.add("1" + largestMagical(binString.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }

        // Step 2: 对好子串按字典序排序
        Collections.sort(goodSubstrings, Collections.reverseOrder());

        // Step 3: 拼接排序后的子串
        StringBuilder result = new StringBuilder();
        for (String sub : goodSubstrings) {
            result.append(sub);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String binString = "1010111000";
        System.out.println(largestMagical(binString));  // 输出 "1110001010"
    }
}
