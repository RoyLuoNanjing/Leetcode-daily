

public class Solution {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }



    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        int count = 0;

        SinglyLinkedListNode ref = llist;

        if (position == 0) {
            return ref.next;
        }

        while (count + 1 != position) {
            llist = llist.next;
            count++;
        }
        llist.next = llist.next.next;

        return ref;
    }
}
