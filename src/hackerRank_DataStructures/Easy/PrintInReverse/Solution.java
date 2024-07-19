package hackerRank_DataStructures.Easy.PrintInReverse;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode head = llist;


        List<Integer> list = new ArrayList<>();

        while (llist != null) {
            list.add(llist.data);
            llist = llist.next;
        }

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

    }
}
