package hackerRank_Algorithms.Medium.BiggerIsGreater;

public class Solution {
    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] chars = w.toCharArray();

        int n = chars.length;

        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i < 0) {
            return "no answer";
        }

        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        swap(chars, i, j);

        reverse(chars, i + 1, n - 1);

        return new String(chars);
    }


    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

}
