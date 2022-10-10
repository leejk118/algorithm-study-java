package main.day1010.leetcode_485;

public class leetcode_485_jklee {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {1, 1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
        };
        for (int[] tc : testcase) {
            System.out.println(new leetcode_485_jklee().findMaxConsecutiveOnes(tc));
        }
    }
}
