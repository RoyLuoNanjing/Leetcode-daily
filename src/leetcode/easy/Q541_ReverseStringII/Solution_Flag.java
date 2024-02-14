package leetcode.easy.Q541_ReverseStringII;

public class Solution_Flag {
    public String reverseStr(String s, int k) {
        StringBuffer temp = new StringBuffer();
        StringBuffer res = new StringBuffer();

        int length = s.length();
        boolean flag = true;

        //正常遍历
        for (int i = 0; i < length; i++) {
            temp.append(s.charAt(i));
            if ((i + 1) % k == 0) {
                res.append(flag?temp.reverse() : temp); //判断翻转
                temp.setLength(0); // 清空
                flag = !flag;     //倒置flag
            }
        }
        res.append(flag ? temp.reverse() : temp) ;    //根据flag清空判断剩余值与k和2k的关系
        return res.toString();
    }

    /**
     * Comment:
     * 暴力解法
     * 不一定是最快的，但是思路却很清晰
     * 用flag来控制翻转
     */
}
