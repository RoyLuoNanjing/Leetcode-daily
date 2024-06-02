package hackerRank.Easy.GetTotalX;

import java.util.List;

public class Solution {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int count = 0;
        for (int i = a.get(a.size()-1); i <= b.get(0); i++) {
            if ( isFactorForAll(i,a) && isFactorOfAll(i,b) ){
                count ++;
            }

        }
        return count;
    }

    public static boolean isFactorOfAll(int num, List<Integer> range){
        for (Integer integer : range) {
            if (integer % num != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isFactorForAll(int num, List<Integer> range){
        for (Integer integer : range) {
            if (num %integer != 0){
                return false;
            }
        }
        return true;
    }
}
