package leetcode.easy.Q257_BinaryTreePaths;

import leetcode.ClassUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
    StringBuffer string = new StringBuffer();

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, List<String> ans) {
        if (root == null) {
            return;
        }
        int startIndex = string.length(); //记录一下此时的叶子长度的index
        string.append(root.val);

        //如果左右子树都是空的说明可以记录进数组里面了
        if (root.left == null && root.right == null) {
            String s = string.toString();
            ans.add(s); // 将buffer转成String放入数组中
        }
        //如果不是最后一个叶子则可以加上->
        string.append("->"); //如果
        dfs(root.left, ans);
        dfs(root.right, ans);
        //到达最后一个叶子的时候将buffer回滚到之前的状态，此时用delete方法来删除叶子从上一次到这一次增加的长度
        string.delete(startIndex,string.length());

    }



    /**
     * Comment:
     * 通过题目描述的根到叶和答案的顺序判断应该是中序，即根左右
     * 要判断是否要往数组加值的条件是左右两个叶子是否为空
     * 另外，当到达最后一个叶子的时候，stringBuffer应该回滚到之前的状态而不是重置
     * 所有巧妙的在之前找到buffer即叶子开始生长时候的长度，和最后找到叶子最后时刻的长度
     * 两者相减即能回滚到上一次根  delete(index1, index2) 为删除buffer两个index区间的值
     */

}
