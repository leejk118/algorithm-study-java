package main.day1107.leetcode_215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_215_pcc2242 {
    /**
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     *
     * 215. Kth Largest Element in an Array
     *
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * You must solve it in O(n) time complexity.
     *
     */

    public static int findKthLargest(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int i = 1;
        int index = set.size() - k + 1;
        for (int j : set) {
            if (i == index) {
                return j;
            }
            i++;
        }
        return -1;
    }

    //    Runtime: 41 ms, faster than 60.30%
    //    Memory Usage: 69.1 MB, less than 79.97%
    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k + 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}

