package hackerRank_DataStructures.Easy.ReverseALinkedList;

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

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here


        List<SinglyLinkedListNode> list = new ArrayList<>();

        while (llist != null) {
            list.add(llist);
            llist = llist.next;
        }

        for (int i = list.size() - 1; i >= 1; i--) {
            SinglyLinkedListNode head = list.get(i);
            head.next = list.get(i - 1);
        }

        list.get(0).next = null;
        return list.get(list.size() - 1);
    }
}
