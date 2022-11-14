package main.day1107.leetcode_160;

import main.util.ListNode;

public class leetcode_160_jklee {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getNodeLength(headA), bLength = getNodeLength(headB);
        int diff = Math.abs(aLength - bLength);
        ListNode answer = null;

        if (aLength > bLength) {
            for (int i = 0; i < diff; ++i) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < diff; ++i) {
                headB = headB.next;
            }
        }

        for (int i = 0, length = Math.min(aLength, bLength); i < length; ++i) {
            if (headA == headB) {
                answer = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return answer;
    }
    private int getNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
