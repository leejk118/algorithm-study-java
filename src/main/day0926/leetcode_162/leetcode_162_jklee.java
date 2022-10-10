package main.day0926.leetcode_162;

public class leetcode_162_jklee {
    public int findPeakElement(int[] nums) {
        int index = nums.length - 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {1, 2, 3, 1},
                {1, 2, 1, 3, 5, 6, 4}
        };
        for (int[] tc : testcase) {
            System.out.println(new leetcode_162_jklee().findPeakElement(tc));
        }
    }
}
