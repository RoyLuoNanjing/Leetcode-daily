package hackerRank.Easy.ViralAdvertising;

public class Solution {
    public static int viralAdvertising(int n) {
        // Write your code here
        int shared = 5;
        int likes = 0;

        for (int i = 0; i < n; i++) {
            int newLikes = shared / 2;
            shared = newLikes * 3;
            likes += newLikes;
        }

        return likes;
    }

}
