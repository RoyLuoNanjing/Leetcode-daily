package hackerRank.Easy.Kangaroo;

public class Solution {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        String yes = "YES";
        String no = "NO";

        int locationA = x1;
        int locationB = x2;

        if (v1 <= v2) {
            return no;
        }

        while (locationA != locationB){

            locationA += v1;
            locationB += v2;

            if (locationA >locationB ){
                return no;
            }

        }

        return yes;
    }
}
