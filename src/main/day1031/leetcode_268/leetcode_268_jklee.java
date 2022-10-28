package main.day1031.leetcode_268;

import java.util.HashSet;

public class leetcode_268_jklee {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; ++i) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return set.iterator().next();
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {3, 0, 1},
                {0, 1},
                {9,6,4,2,3,5,7,0,1}
        };
        for (int[] tc : testcase) {
            System.out.println(new leetcode_268_jklee().missingNumber(tc));
        }
    }
}
