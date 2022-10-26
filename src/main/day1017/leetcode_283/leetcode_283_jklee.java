package main.day1017.leetcode_283;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_283_jklee {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) continue;
            for (int j = i; j < nums.length; ++j) {
                if (nums[j] == 0) continue;
                nums[i] = nums[j];
                nums[j] = 0;
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[][] testcase = {
            {0, 1, 0, 3, 12},
            {0}
        };
        for (int[] tc : testcase) {
            new leetcode_283_jklee().moveZeroes(tc);
        }
    }
}
