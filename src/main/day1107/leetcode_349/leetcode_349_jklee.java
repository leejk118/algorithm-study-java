package main.day1107.leetcode_349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_349_jklee {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> answer = new ArrayList<>();
        boolean[] isExist = new boolean [1001];
        for (int num : nums1) {
            isExist[num] = true;
        }
        for (int num : nums2) {
            if (isExist[num]) {
                answer.add(num);
                isExist[num] = false;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[][] nums1 = {{1, 2, 2, 1}, {4, 9, 5}};
        int[][] nums2 = {{2, 2}, {9, 4, 9, 8, 4}};

        for (int i = 0; i < nums1.length; ++i) {
            System.out.println(Arrays.toString(new leetcode_349_jklee().intersection(nums1[i], nums2[i])));
        }
    }
}
