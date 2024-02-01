package leetcode.medium.Q38_CountAndSay;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_RegularExpression {
    public String countAndSay(int n) {
        //初始值永远为“1”；
        String temp = "1";
        //根据输入n进行遍历
        for (int i = 2; i <= n; i++) {
            temp = processNumber(temp);
        }
        return temp;
    }

    /**
     * 用正则表达式分割string
     * @param m 每次输入的string
     * @return
     */
    private String processNumber (String m ){
        //相同的数字进行分割
        String[] parts = m.split("(?<=(.))(?!\\1)");
        String result =  Arrays.stream(parts).map(part ->{
            int numberOfChar = part.length();
            return String.valueOf(numberOfChar) + part.charAt(0);
        }).collect(Collectors.joining()); //记住stream以后要collect
        return result;
    }
    /**
     * COMMENTS:
     * 我中间用了正则表达式进行字符串分割，逻辑干脆但是性能问题，并且我用了Stream也增加了开销
     * gpt建议对char进行遍历，并计数，性能上开销会低点
     */
}
