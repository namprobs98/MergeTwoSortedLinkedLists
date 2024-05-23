package com.mycompany.mergetwosortedlinkedlists;

import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeTwoSortedLinkedLists {
    public ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
        
        return dummy.next;
    }
    
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static ListNode createListFromInput(Scanner scanner) {
        int n = scanner.nextInt();
        if (n == 0) return null;

        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        return head;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            ListNode head1 = createListFromInput(scanner);
            ListNode head2 = createListFromInput(scanner);

            MergeTwoSortedLinkedLists solution = new MergeTwoSortedLinkedLists();
            ListNode mergedHead = solution.mergeLists(head1, head2);

            printList(mergedHead);
        }

        scanner.close();
    }
}