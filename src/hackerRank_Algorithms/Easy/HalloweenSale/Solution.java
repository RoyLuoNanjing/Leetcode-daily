package hackerRank_Algorithms.Easy.HalloweenSale;

public class Solution {
    public static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        if (s < p) {
            return 0;
        } else {
            s -= p;
        }
        int count = 1;

        int price = p - d;

        while (s > 0) {
            if (s - price < 0) break;
            System.out.println(s);
            if (price > m) {
                if (s - price >= 0) {
                    s -= price;
                    count++;
                }
                price -= d;
            } else {
                price = m;
                if (s - m >= 0) {
                    s -= price;
                    count++;
                }
            }
            System.out.println(price);

            System.out.println("---");
        }
        return count;
    }

    public static void main(String[] args) {
        howManyGames(20, 3, 6, 85);
    }
}
