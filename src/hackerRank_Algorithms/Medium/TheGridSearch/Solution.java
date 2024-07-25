package hackerRank_Algorithms.Medium.TheGridSearch;

import java.util.List;

public class Solution {
    public static String gridSearch(List<String> G, List<String> P) {
        int rowsG = G.size();
        int colsG = G.get(0).length();
        int rowsP = P.size();
        int colsP = P.get(0).length();

        for (int i = 0; i <= rowsG - rowsP; i++) {
            for (int j = 0; j <= colsG - colsP; j++) {
                boolean found = true;

                for (int k = 0; k < rowsP; k++) {
                    String rowG = G.get(i + k).substring(j, j + colsP);
                    String rowP = P.get(k);

                    if (!rowG.equals(rowP)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return "YES";
                }
            }
        }

        return "NO";
    }


}
