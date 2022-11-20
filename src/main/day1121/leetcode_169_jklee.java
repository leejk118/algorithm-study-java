package main.day1121;

import java.util.Arrays;

public class leetcode_169_jklee {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1, maxCount = 1, currentNumber = nums[0], answer = nums[0];
        for (int i = 1, length = nums.length; i < length; ++i) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
                currentNumber = nums[i];
                continue;
            }
            count++;
            if (count > maxCount) {
                maxCount = count;
                answer = currentNumber;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {3, 2, 3},
                {2, 2, 1, 1, 1, 2, 2}
        };

        for (int[] nums : testcase) {
            System.out.println(new leetcode_169_jklee().majorityElement(nums));
        }
    }
}
