package main.day1010.leetcode_141;

import main.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_141_jklee {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (true) {
            if (head == null) {
                return false;
            }
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
    }

    public static void main(String[] args) {

    }
}
