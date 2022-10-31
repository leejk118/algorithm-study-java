package main.day1010.leetcode_141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_141_pcc2242 {
    /**
     * https://leetcode.com/problems/linked-list-cycle/
     *
     * 141. Linked List Cycle
     *
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     */

    static class ListNode {
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
           next = null;
       }
    }
//    Runtime : 0 ms Beats 100%
//    Memory : 43.5 MB Beats 92.58%
    public static boolean hasCycle(ListNode head) {
        int maxValue = Integer.MAX_VALUE;
        ListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.val == maxValue) {
                return true;
            }
            currentNode.val = maxValue;
            currentNode = currentNode.next;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(hasCycle(head));
    }
}

