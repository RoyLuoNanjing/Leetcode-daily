package hackerRank_Algorithms.Medium.MaximumPalindromes;

public class Solution {
    private static final int MOD = 1000000007;
    private static int[][] freq;
    private static long[] fact;
    private static long[] invFact;

    private static void precomputeFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = modInverse(fact[n], MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private static long modInverse(long a, int m) {
        return modPower(a, m - 2, m);
    }

    private static long modPower(long x, long y, int mod) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }
    public static void initialize(String s) {
        int n = s.length();
        freq = new int[26][n + 1];
        precomputeFactorials(n);

        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                freq[j][i + 1] = freq[j][i];
            }
            freq[charIndex][i + 1]++;
        }
    }

    public static int answerQuery(int l, int r) {
        int[] charFreq = new int[26];
        int oddCount = 0;
        int length = r - l + 1;

        for (int i = 0; i < 26; i++) {
            charFreq[i] = freq[i][r] - freq[i][l - 1];
            if (charFreq[i] % 2 != 0) {
                oddCount++;
            }
        }

        int halfPalindromeLength = 0;
        long numerator = 1;

        for (int i = 0; i < 26; i++) {
            halfPalindromeLength += charFreq[i] / 2;
            numerator = numerator * invFact[charFreq[i] / 2] % MOD;
        }


        long denominator = fact[halfPalindromeLength];
        long result = denominator * numerator % MOD;


        if (oddCount > 0) {
            result = result * oddCount % MOD;
        }

        return (int) result;
    }
}
