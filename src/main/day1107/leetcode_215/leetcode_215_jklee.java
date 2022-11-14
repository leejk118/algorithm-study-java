package main.day1107.leetcode_215;

import java.util.PriorityQueue;

public class leetcode_215_jklee {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int num : nums) {
            pq.add(num);
        }
        k = nums.length - k;
        while(k-- >= 0) {
            answer = pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 2, 1, 5, 6, 4},
                {3, 2, 3, 1, 2, 4, 5, 5, 6}
        };
        int[] k = {2, 4};

        for (int i = 0; i < nums.length; ++i) {
            System.out.println(new leetcode_215_jklee().findKthLargest(nums[i], k[i]));
        }
    }
}
