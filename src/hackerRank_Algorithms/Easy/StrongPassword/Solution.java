package hackerRank_Algorithms.Easy.StrongPassword;

import java.util.HashSet;

public class Solution {
    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        boolean containDigit = false;
        boolean containLowerCase = false;
        boolean containUpperCase = false;
        boolean containSpecialChar = false;


        String specialCharString = "!@#$%^&*()-+";

        HashSet<Character> specialCharSet = new HashSet<>();

        for (int i = 0; i < specialCharString.length(); i++) {
            specialCharSet.add(specialCharString.charAt(i));
        }


        String numbers = "0123456789";

        HashSet<Character> digitSet = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            digitSet.add(numbers.charAt(i));
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!containDigit && digitSet.contains(c)) {
                containDigit = true;
            }

            if (!containLowerCase && Character.isLowerCase(c)) {
                containLowerCase = true;
            }

            if (!containUpperCase && Character.isUpperCase(c)) {
                containUpperCase = true;
            }

            if (!containSpecialChar && specialCharSet.contains(c)) {
                containSpecialChar = true;
            }
        }


        int count = 0;

        if (!containDigit) {
            count++;
        }
        if (!containLowerCase) {
            count++;
        }
        if (!containUpperCase) {
            count++;
        }
        if (!containSpecialChar) {
            count++;
        }

        if (n + count < 6) {
            count = 6 - n;
        }

        return count;
    }
}
