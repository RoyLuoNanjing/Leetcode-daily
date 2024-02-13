package leetcode.easy.Q2651_CalculateDelayedArrivalTime;

public class Solution_Math {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime)%24;
    }

    /**
     * Comment:
     * 简单数学
     */
}
