package leetcode.medium.Q79_WordSearch;

import java.util.*;

public class Solution_Backtracking {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 从每个可能的起点启动DFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtracking(board, i, j, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean backtracking(char[][] board, int x, int y, String word, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true; //找到答案了
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false; // 越界或者已经访问过的位置
        }

        if (board[x][y] != word.charAt(index)) {
            return false;   //完全不可能存在 或者 和字符不匹配
        }

        visited[x][y] = true; //标记已经访问了


        //尝试向四个方向去dfs
        if (
                backtracking(board, x + 1, y, word, visited, index + 1)
                        || backtracking(board, x - 1, y, word, visited, index + 1)
                        || backtracking(board, x, y + 1, word, visited, index + 1)
                        || backtracking(board, x, y - 1, word, visited, index + 1)
        ) {
            return true;
        }

        //否则回溯，并撤销标记
        visited[x][y] = false;
        return false;
    }
}
