package leetcode.medium.Q2391_MinimumAmountOfTimeToCollectGarbage;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        //记录下这些垃圾最后出现的地方
        int gEnd = 0;
        int mEnd = 0;
        int pEnd = 0;

        for (int i = 0; i < garbage.length; i++) {
            int glass = 0;
            int metal = 0;
            int paper = 0;

            for (int j = 0; j < garbage[i].length(); j++) {
                switch (garbage[i].charAt(j)) {
                    case 'G':
                        glass++;
                        gEnd = i;
                        break;
                    case 'M':
                        metal++;
                        mEnd = i;
                        break;
                    default:
                        paper++;
                        pEnd = i;
                        break;
                }
            }
            count += glass + metal + paper;
        }

        //gTravel
        for (int i = 0; i < gEnd; i++) {
            count += travel[i];
        }

        //mTravel
        for (int i = 0; i < mEnd; i++) {
            count += travel[i];
        }

        //pTravel
        for (int i = 0; i < pEnd; i++) {
            count += travel[i];
        }


        return count;
    }

    /**
     * Comment：
     * 毫无算法的中等题
     */
}
