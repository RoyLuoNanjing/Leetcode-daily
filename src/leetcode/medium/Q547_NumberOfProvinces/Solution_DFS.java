package leetcode.medium.Q547_NumberOfProvinces;

import java.util.HashSet;
import java.util.Set;

public class Solution_DFS {
    public int findCircleNum(int[][] isConnected) {
        //创建一个集合用于记录访问过的城市
        Set<Integer> visited = new HashSet<>();
        int numProvinces = 0;

        //遍历每个城市
        for (int i = 0; i < isConnected.length; i++) {
            //如果当前城市未被访问过，则启动一次DFS
            if (!visited.contains(i)) {
                //从该城市开始的DFS标识一个新的省份
                dfs(isConnected,i,visited);
                //每次新的DFS意味着找到一个新的省份
                numProvinces++;
            }
        }
        return numProvinces;
    }

    //使用DFS遍历相连城市，标记已访问城市
    private void dfs(int[][] isConnected, int city, Set<Integer> visted) {
        //将当前城市标记为已访问
        visted.add(city);

        //遍历所有城市，看哪些与当前城市直接相连
        for (int i = 0; i < isConnected[city].length; i++) {
            //如果与当前城市直接相连且尚未访问，则递归调用DFS
            if (isConnected[city][i] == 1 && !visted.contains(i)) {
                dfs(isConnected, i, visted);
            }
        }
    }

    /**
     * Comment:
     * 有意思的DFS，感觉以后可以再单独做一遍
     */
}
