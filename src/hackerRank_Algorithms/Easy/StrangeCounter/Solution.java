package hackerRank_Algorithms.Easy.StrangeCounter;

public class Solution {
    public static long strangeCounter(long t) {
        long start = 3;
        while (t > start) {
            t -= start;
            start *= 2;
        }
        return start - t + 1;
    }
}
