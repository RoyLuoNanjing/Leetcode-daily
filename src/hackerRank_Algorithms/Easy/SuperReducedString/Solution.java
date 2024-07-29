package hackerRank_Algorithms.Easy.SuperReducedString;

public class Solution {
    // not fully correct
    public static String superReducedString(String s) {
        // Write your code here
        boolean isConverted = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }


        while (!isConverted) {
            int l = sb.length();
            isConverted = false;
            StringBuilder newSb = new StringBuilder();
            for (int i = 0; i < l - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    i++;
                    isConverted = true;
                    continue;
                }
                newSb.append(sb.charAt(i));
            }
            if (newSb.length()==0) {
                return "Empty String";
            }

            if (sb.charAt(l - 1) == newSb.charAt(newSb.length() - 1)) {
                newSb.deleteCharAt(newSb.length() - 1);
            } else {
                newSb.append(sb.charAt(l - 1));
            }
            sb = newSb;
        }

        if (sb.length() == 0) {
            return "Empty String";
        }
        return sb.toString();
    }


}
