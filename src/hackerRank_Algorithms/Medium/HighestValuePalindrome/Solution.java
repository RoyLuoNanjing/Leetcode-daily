package hackerRank_Algorithms.Medium.HighestValuePalindrome;

import java.util.Arrays;

public class Solution {
    public static String highestValuePalindrome(String s, int n, int k) {
        // Write your code here
        char[] arr = s.toCharArray();
        boolean[] modified = new boolean[n];

        int left = 0, right = n - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                arr[left] = arr[right] = (char) Math.max(arr[left], arr[right]);
                modified[left] = true;
                k--;
            }
            left++;
            right--;
        }

        if (k < 0) {
            return "-1";
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            if (left == right) {
                if (k > 0 && arr[left] != '9') {
                    arr[left] = '9';
                }
            } else {
                if (arr[left] != '9') {
                    if (modified[left] && k > 0) {
                        arr[left] = arr[right] = '9';
                        k--;
                    } else if (!modified[left] && k > 1) {
                        arr[left] = arr[right] = '9';
                        k -= 2;
                    }
                }
            }
            left++;
            right--;
        }
        return new String(arr);
    }
}
