package hackerRank_DataStructures.Easy.TreeTopView;

import hackerRank_DataStructures.classUtils.Node;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {
    public static void topView(Node root) {
        // TreeMap to store the first node at each horizontal distance
        Map<Integer, Pair> topViewMap = new TreeMap<>();
        // Call the recursive function to fill the map
        fillTopViewMap(root, 0, 0, topViewMap);
        // Print the values stored in topViewMap
        for (Map.Entry<Integer, Pair> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    // Helper function to fill the top view map
    private static void fillTopViewMap(Node node, int hd, int height, Map<Integer, Pair> topViewMap) {
        if (node == null) {
            return;
        }
        // If horizontal distance is not already present in the map,
        // or if the current node is at a lower height than the existing node at the same horizontal distance
        if (!topViewMap.containsKey(hd) || topViewMap.get(hd).height > height) {
            topViewMap.put(hd, new Pair(node.data, height));
        }
        // Recur for left and right subtrees
        fillTopViewMap(node.left, hd - 1, height + 1, topViewMap);
        fillTopViewMap(node.right, hd + 1, height + 1, topViewMap);
    }

    static class Pair {
        int data;
        int height;

        Pair(int data, int height) {
            this.data = data;
            this.height = height;
        }
    }

//    关键概念
//    水平距离 (Horizontal Distance, HD)：
//
//    每个节点都有一个水平距离。
//    根节点的水平距离为0。
//    左子节点的水平距离是父节点的水平距离减1。
//    右子节点的水平距离是父节点的水平距离加1。
//    层序遍历 (Level Order Traversal)：
//
//    使用层序遍历来确保按层次顺序访问每个节点。
//    层序遍历通常使用一个队列来实现。
//    记录每个水平距离的第一个节点：
//
//    使用一个数据结构（如 TreeMap 或 HashMap），其键为水平距离，值为相应的节点数据。
//    因为我们是按层次顺序访问节点的，所以第一个出现在某个水平距离上的节点会被记录下来，其他位于同一水平距离的节点会被忽略。
}
