package hackerRank_Algorithms.Easy.ModifiedKaprekarNumbers;

public class Solution {
    public static void kaprekarNumbers(int p, int q) {
        // Write your code here

        int count = 0;
        for (int i = p; i <= q; i++) {
            if (isKaprekarNumbers(i)){
                count++;
                System.out.print(i+" ");

            }
        }

        if (count == 0) {
            System.out.println("INVALID RANGE");
        }

    }

    public static boolean isKaprekarNumbers(int num) {
        long sqr = (long) num * num;
        int d = Integer.toString(num).length();
        String sqrStr = Long.toString(sqr);
        int length = sqrStr.length();

        if (length != 2 * d && length != 2 * d - 1) {
            return false;
        }

        String l = (length - d) == 0?  sqrStr: sqrStr.substring(0, length - d);
        String r = (length - d) == 0?  "0" : sqrStr.substring(length - d);

        int lInt = Integer.parseInt(l);
        int rInt = Integer.parseInt(r);

        int newNum = lInt + rInt;
        return newNum == num;
    }

    public static void main(String[] args) {
        int p = 22222;
        int q = 99999;
        kaprekarNumbers(p, q);
    }

}
