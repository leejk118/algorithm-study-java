package main.day1010.leetcode_61;

import main.util.ListNode;

public class leetcode_61_jklee {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode current = head, lastNode = head;

        while (current != null) {
            length++;
            lastNode = current;
            current = current.next;
        }
        k %= length;
        k = length - k;

        lastNode.next = head;
        while (true) {
            if (k == 0) {
                current = lastNode.next;
                lastNode.next = null;
                break;
            }
            k--;
            lastNode = lastNode.next;
        }

        return current;
    }


    public static void main(String[] args) {

    }
}
