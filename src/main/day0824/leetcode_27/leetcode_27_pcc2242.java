package main.day0824.leetcode_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_27_pcc2242 {
    /**
     * https://leetcode.com/problems/remove-element/
     *
     * 27. Remove Element
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     */

    // 1ms, 42.5MB
    public static int removeElement(int[] nums, int val) {
        int pivot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pivot != i) {
                nums[pivot] = nums[i];
            }

            if (nums[i] != val) {
                pivot++;
            }
        }

        for (int i = pivot; i < nums.length ; i++) {
            nums[i] = '_';
        }

        return pivot;
    }


    public static void main(String[] args) throws IOException {
        int[] inputArr1 = {3, 2, 2, 3};
        int inputVal1 = 3;

        int[] inputArr2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int inputVal2 = 2;


        System.out.println(removeElement(inputArr2, inputVal2));
    }
}

