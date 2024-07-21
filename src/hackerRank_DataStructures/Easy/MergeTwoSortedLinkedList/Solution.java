package hackerRank_DataStructures.Easy.MergeTwoSortedLinkedList;


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

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        // 哨兵节点简化边界情况处理
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // 将剩余节点连接到结果链表
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            // 第一个已排序链表
            int n1 = scanner.nextInt();
            SinglyLinkedList list1 = new SinglyLinkedList();
            for (int i = 0; i < n1; i++) {
                int nodeData = scanner.nextInt();
                list1.insertNode(nodeData);
            }

            // 第二个已排序链表
            int n2 = scanner.nextInt();
            SinglyLinkedList list2 = new SinglyLinkedList();
            for (int i = 0; i < n2; i++) {
                int nodeData = scanner.nextInt();
                list2.insertNode(nodeData);
            }

            // 合并链表
            SinglyLinkedListNode mergedHead = mergeLists(list1.head, list2.head);

            // 打印合并后的链表
            printList(mergedHead);
        }

        scanner.close();
    }

    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

