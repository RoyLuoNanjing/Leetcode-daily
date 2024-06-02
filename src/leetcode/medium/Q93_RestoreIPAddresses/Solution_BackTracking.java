package leetcode.medium.Q93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution_BackTracking {
    //结果
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //这种情况都不能满足条件
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        List<String> current = new ArrayList<>();
        backtracking(s, 0, current,0);
        return res;
    }

    public void backtracking(String s, int start,List<String> current, int count) {
        if (count > 4) return;// 超过四段
        if (count == 4 && start == s.length()){ //找到了有效解
            res.add(String.join(".", current));
            return;
        }

        //start + 3这边很巧妙，因为我们每次开始一个词的时候，我们只需要回溯其到后面两位的数
        for (int i = start; i < start + 3 &&  i < s.length() ; i++) {
            String segment = s.substring(start,i + 1);
            //前导零判断，或者数值过大
            if ((segment.length() > 1 && segment.startsWith("0")) || Integer.parseInt(segment) > 255){
                break;
            }

            current.add(segment);
            backtracking(s,i + 1,current, count + 1);
            current.removeLast(); //回溯移除最后一个添加的片段
        }

    }
    /**
     * Comment:
     * 有意思的回溯题目
     * 利用dfs的标准模板，即在遍历中 add , backtracking, 移除最后一个
     */
}

