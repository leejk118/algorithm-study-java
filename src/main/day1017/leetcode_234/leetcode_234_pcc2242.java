package main.day1017.leetcode_234;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_234_pcc2242 {
    /**
     * https://leetcode.com/problems/palindrome-linked-list/
     *
     * 234. Palindrome Linked List
     *
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     *
     */

//    Runtime 8 ms Beats 64.23%
//    Memory 54.6 MB Beats 95.18%
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ListNode input = new ListNode(1, new ListNode(10, new ListNode(10)));
        System.out.println(isPalindrome(input));

    }
}

