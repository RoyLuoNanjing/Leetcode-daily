package hackerRank_DataStructures.Easy.InsertANodeAtTheTailOfALinkedList;

import hackerRank_DataStructures.classUtils.SinglyLinkedListNode;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();


        int count = 0;

        int first = scanner.nextInt();
        SinglyLinkedListNode head = new SinglyLinkedListNode(first, null);

        SinglyLinkedListNode res = head;
        while (count <= n) {
            if (!scanner.hasNext()) break;
            int num = scanner.nextInt();
            SinglyLinkedListNode node = new SinglyLinkedListNode(num, null);
            head.next = node;
            head = head.next;
            count++;
        }

        while (res != null){
            System.out.println(res.data);
            res = res.next;
        }
        scanner.close();
    }
}
