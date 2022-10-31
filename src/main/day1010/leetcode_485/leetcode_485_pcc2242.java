package main.day1010.leetcode_485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    /**
     * https://leetcode.com/problems/max-consecutive-ones/
     *
     * 485. Max Consecutive Ones
     *
     * Given a binary array nums, return the maximum number of consecutive 1's in the array.
     *
     */

//    Runtime 2 ms Beats 95.47%
//    Memory 56.6 MB Beats 54.17%
    public static int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                count++;
            } else {
                answer = Math.max(answer, count);
                count = 0;
            }
        }

        return Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}

