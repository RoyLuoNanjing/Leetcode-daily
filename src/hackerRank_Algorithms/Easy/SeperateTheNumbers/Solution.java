package hackerRank_Algorithms.Easy.SeperateTheNumbers;

public class Solution {
    public static void separateNumbers(String s) {
        // Write your code here
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            String firstNumberStr = s.substring(0, i);
            long firstNum = Long.parseLong(firstNumberStr);
            long nextNum = firstNum;
            StringBuilder generatedString = new StringBuilder();

            while (generatedString.length()<n){
                generatedString.append(nextNum);
                nextNum++;
            }

            if (generatedString.toString().equals(s)){
                System.out.println("YES " + firstNum);
                return;
            }
        }
        System.out.println("NO");
    }
}
