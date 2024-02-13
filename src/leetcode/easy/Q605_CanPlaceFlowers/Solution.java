package leetcode.easy.Q605_CanPlaceFlowers;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int head = flowerbed[0];

        //处理只有一个数的情况
        if (flowerbed.length == 1){
            return head == 0 ? 1>=n : 0 >=n;
        }
        int tail = flowerbed[flowerbed.length - 1];

        int count = 0;


        //处理头部为0
        if (head == 0 && flowerbed [1] == 0){
            count ++;
            flowerbed[0] = 1;
        }

        //处理尾部为0
        if (tail == 0 && flowerbed [flowerbed.length - 2] == 0){
            count ++;
            flowerbed[flowerbed.length - 2] = 1;
        }

        //判断前中后是否为0
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed [i] ==0) {
                flowerbed [i] = 1;
                count++;
            }
        }
        return count >= n;
    }
    /**
     * Comment:
     * 暴力解法
     * 但是用时击败84.06%的用户
     */
}
