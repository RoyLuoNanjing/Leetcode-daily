package hackerRank_DataStructures.Easy.CompareTwoLinkedList;


import java.util.Scanner;

public class Solution {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            // First linked list
            int n1 = scanner.nextInt();
            SinglyLinkedList list1 = new SinglyLinkedList();
            for (int i = 0; i < n1; i++) {
                int nodeData = scanner.nextInt();
                list1.insertNode(nodeData);
            }

            // Second linked list
            int n2 = scanner.nextInt();
            SinglyLinkedList list2 = new SinglyLinkedList();
            for (int i = 0; i < n2; i++) {
                int nodeData = scanner.nextInt();
                list2.insertNode(nodeData);
            }

            // Compare lists
            boolean result = compareLists(list1.head, list2.head);
            System.out.println(result ? 1 : 0);
        }

        scanner.close();
    }
}