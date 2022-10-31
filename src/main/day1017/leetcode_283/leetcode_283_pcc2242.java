package main.day1017.leetcode_283;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_283_pcc2242 {
    /**
     * https://leetcode.com/problems/move-zeroes/
     *
     * 283. Move Zeroes
     *
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     *
     */


//    Runtime 9 ms Beats 25.78%
//    Memory 54.8 MB Beats 51.32%
    public static void moveZeroes(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                newNums[index] = nums[i];
                index++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

//     Runtime 1 ms Beats 100%
//     Memory 43.9 MB Beats 86.91%'
    public static void moveZeroes2(int[] nums) {
        int index = 0;
        int zeroCount = 0;
        int i = 0;
        while (i < nums.length) {
            nums[index] = nums[i];

            if (nums[i] != 0) {
                index++;
            } else {
                zeroCount++;
            }

            i++;
        }

        while (zeroCount > 0) {
            nums[nums.length  - zeroCount] = 0;
            zeroCount--;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        moveZeroes2(new int[]{0,1,0,3,12});
    }
}

