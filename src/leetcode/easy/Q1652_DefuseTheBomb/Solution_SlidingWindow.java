package leetcode.easy.Q1652_DefuseTheBomb;

public class Solution_SlidingWindow {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] answer = new int[n];

        if (k == 0) {
            return new int[n]; // 全零数组
        }

        int sum = 0; // 初始化窗口和

        // 初始化窗口和：如果 k > 0，初始化从 1 到 k；如果 k < 0，初始化从 -1 到 k
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i % n];
            }
        } else {
            for (int i = -1; i >= k; i--) {
                sum += code[(n + i) % n];
            }
        }

        // 使用滑动窗口法，计算每个位置的和
        for (int i = 0; i < n; i++) {
            answer[i] = sum;

            // 移动窗口：移除即将离开的值，并添加新进入的值
            if (k > 0) {
                sum -= code[(i + 1) % n]; // 移除即将离开的值
                sum += code[(i + 1 + k) % n]; // 添加新进入的值
            } else {
                sum -= code[(n + i + k) % n]; // 移除即将离开的值
                sum += code[(n + i - 1) % n]; // 添加新进入的值
            }
        }

        return answer;
    }
    /**
     * Comment:
     * 不知为何滑动窗口没有做对
     */
}
