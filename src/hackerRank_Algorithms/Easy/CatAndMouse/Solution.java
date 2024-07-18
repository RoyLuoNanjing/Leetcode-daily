package hackerRank_Algorithms.Easy.CatAndMouse;

public class Solution {
    static String catAndMouse(int x, int y, int z) {
        int xDistance = Math.abs(x - z);
        int yDistance = Math.abs(y - z);

        if (xDistance < yDistance){
            return "Cat A";
        } else if (xDistance > yDistance){

            return "Cat B";
        } else {
            return "Mouse C";
        }

    }
}
