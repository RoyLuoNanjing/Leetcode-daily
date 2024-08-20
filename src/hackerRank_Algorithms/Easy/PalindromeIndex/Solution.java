package hackerRank_Algorithms.Easy.PalindromeIndex;

public class Solution {
    public static int palindromeIndex(String s) {
        // Write your code here
        int left = 0;
        int right = s.length() - 1;


        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                return -1;
            }
        }
        return -1;

    }
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
