package hackerRank_Algorithms.Medium.TheTimeInWords;

import java.util.Map;
import java.util.HashMap;


public class Solution {
    public static String timeInWords(int h, int m) {
        // Write your code here


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "quarter");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(21, "twenty one");
        map.put(22, "twenty two");
        map.put(23, "twenty three");
        map.put(24, "twenty four");
        map.put(25, "twenty five");
        map.put(26, "twenty six");
        map.put(27, "twenty seven");
        map.put(28, "twenty eight");
        map.put(29, "twenty nine");
        map.put(30, "half");


        if (m == 0) {
            String hour = map.get(h);
            return hour + " o' clock";
        }

        String connector = m > 30 ? "to" : "past";
        String minuteStr = m == 1 ? "minute" : "minutes";

        if (m > 30) {
            h++;
            m = 60 - m;
        }

        String hour = map.get(h);
        String minute = map.get(m);

        String res =( m == 15 || m == 30) ?minute + " " +connector + " " +hour :
                minute + " " + minuteStr + " " +connector + " " +hour;

        return res ;
    }
}
