package main.day1107.leetcode_160;

import main.util.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class leetcode_160_pcc2242 {
    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     *
     * 160. Intersection of Two Linked Lists
     *
     * Given the heads of two singly linked-lists headA and headB,
     * return the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, return null.
     *
     * Could you write a solution that runs in O(m + n) time and use only O(1) memory?
     */

//    Runtime 2241 ms Beats 5.9%
//    Memory 55.2 MB Beats 59.66%
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode current = headA;

        while (current != null) {
            list.add(current);
            current = current.next;
        }

        current = headB;

        while (current != null) {
            if (list.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

//    Runtime: 2 ms, faster than 81.05%
//    Memory Usage: 55 MB, less than 64.10%
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        int valueA = -1;
        int valueB = -1;
        int sizeA = 0;
        int sizeB = 0;

        while (currentA != null) {
            valueA = currentA.val;
            currentA = currentA.next;
            sizeA++;
        }

        while (currentB != null) {
            valueB = currentB.val;
            currentB = currentB.next;
            sizeB++;
        }

        if (valueA != valueB || valueA < 0) {
            return null;
        }
        currentA = headA;
        currentB = headB;

        while (sizeA > sizeB) {
            currentA = currentA.next;
            sizeA--;
        }

        while (sizeB > sizeA) {
            currentB = currentB.next;
            sizeB--;
        }

        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}

