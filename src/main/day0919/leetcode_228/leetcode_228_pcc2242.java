package main.day0919.leetcode_228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class leetcode_228_pcc2242 {
    /**
     * https://leetcode.com/problems/summary-ranges/description/
     *
     * 228. Summary Ranges
     *
     */

//    Runtime: 10 ms, faster than 40.70%
//    Memory Usage: 42.3 MB, less than 52.36%
    public static List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        int length = nums.length;

        if (length == 0) {
            return answer;
        }

        Arrays.sort(nums);
        int pivot = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                answer.add(pivot == nums[i - 1] ? String.valueOf(pivot) :pivot + "->" + nums[i - 1]);
                pivot = nums[i];
            }
        }

        answer.add(pivot == nums[length - 1] ? String.valueOf(pivot) :pivot + "->" + nums[length - 1]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[]{0,1,2,4,5,7};

        int[] input2 = new int[]{-3, 0, 2, 4};
        System.out.println(summaryRanges(input));
    }
}

