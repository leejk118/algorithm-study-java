package main.day1031.leetcode_268;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_268_pcc2242 {
    /**
     * https://leetcode.com/problems/missing-number/
     *
     * 268. Missing Number
     *
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     */

//    Runtime 6 ms Beats 29.64%
//    Memory 42.9 MB Beats 93.10%
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(missingNumber(new int[]{1, 0, 3}));
    }
}

