package main.day1107.leetcode_11;

public class leetcode_11_jklee {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxSize = 0;

        while (true) {
            if (left > right) break;
            maxSize = Math.max(maxSize, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxSize;
    }


    public static void main(String[] args) {
        int[][] testcase = {
                {1, 8, 6, 2, 5, 4, 8, 3, 7},
                {1, 1}
        };

        for (int[] tc : testcase) {
            System.out.println(new leetcode_11_jklee().maxArea(tc));
        }
    }
}
