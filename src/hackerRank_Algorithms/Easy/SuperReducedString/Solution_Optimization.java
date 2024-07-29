package hackerRank_Algorithms.Easy.SuperReducedString;

public class Solution_Optimization {
    public static String superReducedString(String s) {
        // Write your code here
        StringBuilder sb = new StringBuilder(s);

        boolean isReduced = true;
        while (isReduced) {
            isReduced = false;
            StringBuilder newSb = new StringBuilder();
            int i = 0;
            while (i < sb.length()) {
                if (i < sb.length() - 1 && sb.charAt(i) == sb.charAt(i + 1)) {
                    // Skip the next character as well
                    i += 2;
                    isReduced = true;
                } else {
                    newSb.append(sb.charAt(i));
                    i++;
                }
            }
            sb = newSb;
        }

        if (sb.length() == 0) {
            return "Empty String";
        }
        return sb.toString();
    }
}
