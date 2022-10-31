package main.day1010.leetcode_61;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_61_pcc2242 {
    /**
     * https://leetcode.com/problems/rotate-list/
     *
     * 61. Rotate List
     *
     * Given the head of a linked list, rotate the list to the right by k places.
     *
     */


    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

//    Runtime 1 ms Beats 84.64%
//    Memory 43.2 MB Beats 31.91%
    public static ListNode rotateRight(ListNode head, int k) {
        int listSize = countLinkedList(head);
        k %= (listSize > 0 ? listSize : 1);

        if (head == null || k == 0 || listSize < 2) {
            return head;
        }

        ListNode cutLineNode = getNode(head, listSize - k);
        ListNode newHead = cutLineNode.next;
        ListNode lastNode = getNode(head, listSize);

        cutLineNode.next = null;
        lastNode.next = head;
        return newHead;
    }

    private static int countLinkedList(ListNode head) {
        int listSize = 0;
        ListNode currentNode = head;

        while (currentNode != null) {
            listSize++;
            currentNode = currentNode.next;
        }

        return listSize;
    }

    private static ListNode getNode(ListNode head, int num) {
        ListNode currentNode = head;

        int i = 1;
        while (i++ != num) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private static void printNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val + "//");
            current = current.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        ListNode answer1 = rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);
        ListNode answer = rotateRight(new ListNode(1), 3);

        //        ListNode answer1 = rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);

    }

}

