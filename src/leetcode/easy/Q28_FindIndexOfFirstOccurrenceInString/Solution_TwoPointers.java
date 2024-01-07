package leetcode.easy.Q28_FindIndexOfFirstOccurrenceInString;

public class Solution_TwoPointers {

    /**
     * 这种方法忽略了一种情况，即舍去的部分也可能是新的答案的开始
     * 例如： haystack = "mississippi" needle = "issip"
     * 当issis 因为最后一个p不一样而重置pointer指针时忽视了issis后边的is可以作为新的部分的开头
     * 这种情况没有被考虑
     */
//    public int strStr(String haystack, String needle) {
//        //haystack 干草堆
//
//        int haystackLength = haystack.length();
//        int needleLength = needle.length();
//
//        int pointerHaystack = -1; //记录答案开始时候的index
//        int pointerNeedle = 0;
//
//
//        for (int i = 0; i < haystackLength; ++i) {
//
//
//            if (haystack.charAt(i) == needle.charAt(pointerNeedle)){
//                //比较此时指向的两个字符是不是相等，如果相等则比较下一个
//                pointerNeedle++;
//            }else{
//                //不相等的话，就要重置下needle的指针
//                pointerNeedle =0;
//            }
//
//
//            //如果needle的指针超过了needle的范围则说明找到了答案
//            if (pointerNeedle ==needleLength ){
//                pointerHaystack = i - needleLength;
//                break;
//            }
//        }
//        return pointerHaystack;
//    }


    /**
     * 新方法引入了temp指针用于做回滚
     */

    public int strStr(String haystack, String needle) {

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        int pointerTemp = 0; //记录答案开始时候的index
        int pointerHaystack = 0;
        int pointerNeedle = 0;


        while (pointerHaystack <= haystackLength - 1) {
            if (pointerNeedle == needleLength) {
                break;
            }
            if (haystack.charAt(pointerHaystack) == needle.charAt(pointerNeedle)) {
                pointerHaystack++;
                pointerNeedle++;
            } else {
                pointerTemp++;
                pointerNeedle = 0;
                pointerHaystack = pointerTemp;
            }
        }

        //结果的index为指针对于字符串长度的倒推
        int result = pointerHaystack - needleLength;

        // 完成时，needle指针没有指到最后一个char则表明不存在
        return pointerNeedle != needleLength ? -1 : result;
    }
    /**
     * COMMENTS:

     public int strStr(String haystack, String needle) {
     return haystack.indexOf(needle);
     }

     1. 实际上可以用这种直接的调用api的方法

     2. 官方答案中最佳的方法是KMP算法，但是吧，比较难

     3. 其他的都是时间复杂度较高的暴力算法

     */

}
