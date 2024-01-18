package leetcode.easy.Q501_FindModeInBinarySearchTree;

import com.sun.source.tree.Tree;
import leetcode.ClassUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {

    List<Integer> modes = new ArrayList<>(); //因为数量不固定，需要用数组列表
    int pre =  Integer.MIN_VALUE; //不能用0，不然会造成干扰
    int count = 1;
    int maxCount = 0;


    public int[] findMode(TreeNode root) {
        //保证只有一个node的时候，输出那个唯一node的值
        if (root.left == null && root.right == null) return new int[]{root.val};

        dfs(root);
        //将数组列表转化为要求的数组
        int[] resultArray = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            resultArray[i] = modes.get(i);
        }
        return resultArray;

    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        //如果现在的值不等于前面的值，则需要count变为1
        if (root.val != pre) {
            //并且计数归1,因为要重新数新的值
            count = 1;

        } else {
            //否则就数量+1
            count++;
        }

        //判断一下如果此时计数大于之前的最大计数
        if (count > maxCount) {
            //更改一下最大计数
            maxCount = count;
            //清空列表并装入新值
            modes.clear();
            modes.add(root.val);
        }
        //如果相等则装入列表中
        else if (count == maxCount) {
            modes.add(root.val);
        }

        //结束时更新一下前值
        pre = root.val;
        dfs(root.right);
    }

};

/**
 * Comment:
 * 此题主要是在二叉树中找到出现次数最多的值
 * 关键点1 二叉搜索树的特性是左边小，右边大
 * 则可以用中序遍历，进行左根右的遍历
 * 关键点2 可以用hashmap来记录数字出现的次数，但是题目建议空间复杂度尽可能低
 * 则可以通过搜索树的特性来记录，因为搜索到的值一定是从小到大连续的
 *
 *
 * 写起来还是有点难的，一定要对条件有好的理解，尤其是在顺序上
 */

