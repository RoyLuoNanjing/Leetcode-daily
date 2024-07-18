package hackerRank.Medium.Encryption;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String encryption(String s) {
        // Write your code here
        int l = s.length();

        double sqr = Math.sqrt(l);

        int floor = (int) Math.floor(sqr);
        int ceil = (int) Math.ceil(sqr);

        List<String> list = new ArrayList<>();

        int start = 0;

        do {
            StringBuilder str = new StringBuilder();
            for (int i = start; i < start + ceil; i++) {
                if (i < l) {
                    str.append(s.charAt(i));
                }
            }
            if (!str.isEmpty()) {
                list.add(str.toString());
            }
            start += ceil;
        } while (start < l);

        List<String> res = new ArrayList<>();

        System.out.println(list);

        for (int i = 0; i < ceil; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).length() <= i) continue;
                str.append(list.get(j).charAt(i));

            }
            res.add(str.toString());
        }

        String result = String.join(" ", res);
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        encryption("feedthedog");
    }
}
