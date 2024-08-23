package hackerRank_OneWeekPreparationKit.Day1.PlusMinus;

import java.util.List;

public class Solution {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double numOfPositive = 0;
        double numOfNegative = 0;
        double numOfZero = 0;


        for (int num : arr
        ) {
            if (num > 0) {
                numOfPositive++;
            } else if (num < 0) {
                numOfNegative++;
            } else {
                numOfZero++;
            }
        }

        double result1 = numOfPositive / arr.size();
        double result2 = numOfNegative / arr.size();
        double result3 = numOfZero / arr.size();

        System.out.printf("%.6f%n", result1);
        System.out.printf("%.6f%n", result2);
        System.out.printf("%.6f%n", result3);

    }
}
