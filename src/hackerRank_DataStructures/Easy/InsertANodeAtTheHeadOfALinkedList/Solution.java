package hackerRank_DataStructures.Easy.InsertANodeAtTheHeadOfALinkedList;

import hackerRank_DataStructures.classUtils.SinglyLinkedListNode;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();


        int[] arr = new int[n];

        int count = 0;

        while (count <= n) {
            if (!scanner.hasNext()) break;
            int value =  scanner.nextInt();

            arr[count] =value;
            count++;
        }


        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        SinglyLinkedListNode res = head;
        for (int i = n - 1; i >= 0; i--) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(arr[i]);
            head.next = node;
            head = head.next;
        }

        res = res.next;
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }

    }


}
