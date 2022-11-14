package main.day1107.leetcode_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class leetcode_11_pcc2242 {
    /**
     * https://leetcode.com/problems/container-with-most-water/
     *
     * 11. Container With Most Water
     *
     * You are given an integer array height of length n.
     * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     */

//    Runtime: 423 ms, faster than 5.32%
//    Memory Usage: 73.5 MB, less than 70.04%
    public static int maxArea(int[] height) {
        int answer = 0;

        for (int i = 0; i < height.length; i++) {
            if (((height.length - i - 1) * height[i]) < answer) {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                answer = Math.max(answer, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return answer;
    }

    // ---- after
    // Tow Pointer & Sliding Window
    //Runtime: 17 ms, faster than 23.41%
    //Memory Usage: 74 MB, less than 61.03%
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        while (left < right) {
            answer = Math.max(answer, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] == height[right]) {
                left++;
                right--;
            } else {
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(maxArea2(new int[]{1,7,6,2,5,4,8,3,7}));
    }
}

