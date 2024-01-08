package leetcode.easy.Q344_ReverseString;

public class Solution_TwoPointers {
    public void reverseString(char[] s) {
        char temp;
        int pointerHead = 0;
        int pointerTail = s.length -1;
        while(pointerHead < pointerTail){
            temp = s[pointerHead];
            s[pointerHead] = s[pointerTail];
            s[pointerTail] = temp;
            pointerHead++;
            pointerTail--;
        }
    }

    /**
     * Comment:
     * 如果要保证空间复杂度为O（1）,则确保不能创建新的Array
     * To make sure the space complexity is O(1), no new object should be created
     * Therefore it is better to use two pointers method to swap the head and tail
     */
}
