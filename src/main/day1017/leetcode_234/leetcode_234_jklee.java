package main.day1017.leetcode_234;

import main.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_234_jklee {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        boolean answer = true;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        for (int i = 0; i < length / 2; ++i) {
            if (!list.get(i).equals(list.get(length - i - 1))) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
