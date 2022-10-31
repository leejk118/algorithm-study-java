package main.day0919.leetcode_34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_34_pcc2242 {
    /**
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
     *
     * 34. Find First and Last Position of Element in Sorted Array
     *
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     */

//    Runtime: 1 ms, faster than 39.95%
//    Memory Usage: 47.7 MB, less than 9.85%
    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int start = -1;
        int end = -1;

        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] == target) {
                start = end = middle;
                while (start - 1 >= 0  && nums[start - 1] == target) {
                    start--;
                }
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                break;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;

        int[] nums2 = {5, 7 ,7, 8, 8};
        int target2 = 6;

        int[] nums3 = {1};
        int target3 = 1;

        System.out.println(Arrays.toString(searchRange(nums3, target3)));
    }
}

