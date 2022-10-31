package main.day0926.leetcode_162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_162_pcc2242 {
    /**
     * https://leetcode.com/problems/find-peak-element/
     *
     * 162. Find Peak Element
     *
     * A peak element is an element that is strictly greater than its neighbors.
     * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
     * return the index to any of the peaks.
     * You may imagine that nums[-1] = nums[n] = -∞. In other words,
     * an element is always considered to be strictly greater than a neighbor that is outside the array.
     * You must write an algorithm that runs in O(log n) time.
     *
     */

//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 41.6 MB, less than 95.60%
    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (nums[m] > (m - 1 > -1 ? nums[m - 1] : Long.MIN_VALUE) ) {
                if (nums[m] > (m + 1 < nums.length ? nums[m + 1] : Long.MIN_VALUE)) {
                    return m;
                }

                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{0}));
    }
}

