package hackerRank_Algorithms.Easy.StrangeCounter;

public class Solution_Brutal {
    public static long strangeCounter(long t) {
        // Write your code here
        long ref = 3;
        long value = 3;
        long time = 1;

        while (true) {
            System.out.println(time + "----" + value);
            if (time == t) {
                return value;
            }

            if (value == 1) {
                ref = 2 * ref;
                value = ref;
                time++;
                continue;
            }
            value--;
            time++;
        }
    }
}
