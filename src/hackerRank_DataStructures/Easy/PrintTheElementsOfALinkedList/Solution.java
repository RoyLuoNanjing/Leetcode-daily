package hackerRank_DataStructures.Easy.PrintTheElementsOfALinkedList;

public class Solution {

    static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
